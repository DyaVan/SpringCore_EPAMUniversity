package com.diachuk.sspring.app.loggers;

import com.diachuk.sspring.app.Event;

/**
 * Created by VA-N_ on 15.03.2017.
 */
public class ConsoleEventLogger implements IEventLogger {

    public void logEvent(Event event) {
        System.out.println(event.getMsg());
    }
}
