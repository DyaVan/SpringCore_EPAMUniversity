package com.diachuk.sspring.app.loggers;

import com.diachuk.sspring.app.Event;

import java.util.List;

/**
 * Created by Ivan_Diachuk on 3/17/2017.
 */
public class CombinedEventLogger implements IEventLogger {

    private List<IEventLogger> loggers;

    public CombinedEventLogger(List<IEventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (IEventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }

}
