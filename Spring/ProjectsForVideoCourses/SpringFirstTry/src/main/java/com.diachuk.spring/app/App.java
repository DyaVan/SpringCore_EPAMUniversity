package com.diachuk.spring.app;

import com.diachuk.spring.app.loggers.CacheFileEventLogger;
import com.diachuk.spring.app.loggers.CombinedEventLogger;
import com.diachuk.spring.app.loggers.ConsoleEventLogger;
import com.diachuk.spring.app.loggers.IEventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Map;

/**
 * Created by VA-N_ on 15.03.2017.
 */
public class App {

    private Client client;
    private static ConfigurableApplicationContext ctx;
    private Map<EventType, IEventLogger> eventLoggerMap;

    public App(Client client, Map<EventType, IEventLogger> eventLoggerMap) {
        this.client = client;
        this.eventLoggerMap = eventLoggerMap;
    }

    //region GettersVsSetters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        client = client;
    }

    //endregion

    public void logEvent(Event event) {
        String newMsg = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(newMsg);

        IEventLogger eventLogger;
        eventLogger = ctx.getBean(CacheFileEventLogger.class);
        eventLogger.logEvent(event);
    }

    public void replaceIdToName(Event event) {
        String newMsg = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(newMsg);
    }

    public void logEvent(Event event, EventType eventType) {
        replaceIdToName(event);

        IEventLogger eventLogger = eventLoggerMap.get(eventType);
        if (eventLogger != null) {
            eventLogger.logEvent(event);
        }else {
            ctx.getBean(CacheFileEventLogger.class).logEvent(event);
        }
    }

    public static void main(String[] args) {
        ctx = new FileSystemXmlApplicationContext("AppConfig.xml");
        App app = (App) ctx.getBean("app");

        app.logEvent(ctx.getBean("event", Event.class), EventType.INFO);
        app.logEvent(ctx.getBean("event", Event.class), EventType.ERROR);
        app.logEvent(ctx.getBean("event", Event.class));

        ctx.close();

    }
}
