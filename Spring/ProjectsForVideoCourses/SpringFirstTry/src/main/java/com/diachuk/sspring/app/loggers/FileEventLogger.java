package com.diachuk.sspring.app.loggers;

import com.diachuk.sspring.app.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ivan_Diachuk on 3/16/2017.
 */

@Component("lolka")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FileEventLogger implements IEventLogger {


    @Autowired
    protected File logFile;

    @PostConstruct
    private void init() throws IOException {
//        System.out.println("FileEventLogger INIT");
        System.out.println(this.getClass().getSimpleName());

        if (!logFile.canWrite()) {
            throw new IOException();
        }
    }

    public FileEventLogger(File logFile) {
        this.logFile = logFile;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(logFile, event.getMsg(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    ApplicationContext ctx;

    @Lookup("protik")
    public ProtoClass getProtik(){
        System.out.println("DSADSDASD");
        return null;
    }


    public void doMethod() {

        System.out.println((getProtik().number));
    }

}
