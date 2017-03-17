package com.diachuk.spring.app.loggers;

import com.diachuk.spring.app.Event;

import java.io.IOException;

/**
 * Created by VA-N_ on 15.03.2017.
 */
public interface IEventLogger {

    void logEvent(Event event);

}
