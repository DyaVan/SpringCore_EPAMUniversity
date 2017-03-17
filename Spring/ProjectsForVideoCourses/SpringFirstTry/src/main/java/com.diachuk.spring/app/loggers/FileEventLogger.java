package com.diachuk.spring.app.loggers;

import com.diachuk.spring.app.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ivan_Diachuk on 3/16/2017.
 */
public class FileEventLogger implements IEventLogger{

    protected File logFile;

    private void init() throws IOException {
        if (!logFile.canWrite()) {
            throw new IOException();
        }
    }

    public FileEventLogger(File logFile) {
        this.logFile = logFile;
    }

    public void logEvent(Event event)  {
        try {
            FileUtils.writeStringToFile(logFile, event.getMsg(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
