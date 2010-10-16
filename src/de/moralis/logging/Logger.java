package de.moralis.logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static java.lang.Boolean.TRUE;
import static java.util.logging.Level.OFF;

public class Logger {
    private final java.util.logging.Logger log;

    private Logger(java.util.logging.Logger log) {
        this.log = log;
    }

    public static Logger createLogger(String name) {
        java.util.logging.Logger log = java.util.logging.Logger.getLogger(name);
        log.setUseParentHandlers(false);

        try {
            FileHandler fileHandler = new FileHandler(new File(".").getCanonicalPath() + "\\logs\\xml\\" + name + ".xml");
            log.addHandler(fileHandler);
        } catch (IOException e) {
            log.severe("can not create file handler: " + e.getMessage());
        }

        if (Boolean.valueOf(System.getProperty("debug")) != TRUE) {
            log.setLevel(OFF);
        }

        return new Logger(log);
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void warning(String msg) {
        log.warning(msg);
    }

    public void setLogLevel(Level logLevel) {
        log.setLevel(logLevel);
    }
}
