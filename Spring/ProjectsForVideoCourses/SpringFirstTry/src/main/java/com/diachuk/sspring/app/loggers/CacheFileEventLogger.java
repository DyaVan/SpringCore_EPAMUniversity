package com.diachuk.sspring.app.loggers;

import com.diachuk.sspring.app.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan_Diachuk on 3/16/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheLimit = 0;

    private List<Event> cachedEvents = new ArrayList<Event>();


    public CacheFileEventLogger(File logFile, int cacheLimit) {
        super(logFile);
        this.cacheLimit = cacheLimit;
    }

    @Override
    public void logEvent(Event event) {
        if (cachedEvents.size() < cacheLimit) {
            cachedEvents.add(event);
        } else {
            writeCachedEvents();
        }
    }

    private void writeCachedEvents() {
        for (Event e : cachedEvents) {
            super.logEvent(e);
        }
        cachedEvents.clear();
    }

    public void destroy() {
        if (cachedEvents.size() > 0) {
            writeCachedEvents();
        }
    }
}
