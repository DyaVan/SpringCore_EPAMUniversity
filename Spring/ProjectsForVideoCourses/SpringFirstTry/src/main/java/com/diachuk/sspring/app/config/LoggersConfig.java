package com.diachuk.sspring.app.config;

import com.diachuk.sspring.app.loggers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan_Diachuk on 3/22/2017.
 */
@Configuration
@ComponentScan()
public class LoggersConfig {


    @Bean
    CombinedEventLogger combinedEventLogger() {
        List<IEventLogger> loggers = new ArrayList<IEventLogger>();

        return new CombinedEventLogger(new ArrayList<IEventLogger>() {{
            add(fileEventLogger());
            add(consoleEventLogger());
            add(cacheFileEventLogger());
        }}
        );

    }


    @Bean
    ConsoleEventLogger consoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean(initMethod = "init")
    CacheFileEventLogger cacheFileEventLogger(){
        return new CacheFileEventLogger(logFile(),10);
    }

    @Bean(initMethod = "init")
    FileEventLogger fileEventLogger() {
        return new FileEventLogger(logFile());
    }

    @Bean
    File logFile() {
        return new File("D:\\Ivan_Diachuk\\Git_Shared_Dir\\Spring\\ProjectsForVideoCourses\\SpringFirstTry\\src\\main\\resources\\log");
    }
}
