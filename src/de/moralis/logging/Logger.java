package de.moralis.logging;

import java.io.IOException;
import java.util.logging.FileHandler;

import static java.lang.Boolean.TRUE;
import static java.util.logging.Level.*;

public class Logger {
    private final java.util.logging.Logger log;

    private Logger(java.util.logging.Logger log) {
        this.log = log;
    }

    public static Logger createLogger(String name) {
        java.util.logging.Logger log = java.util.logging.Logger.getLogger(name);
        log.setUseParentHandlers(false);

        try {
            FileHandler fileHandler = new FileHandler("logs/xml/" + name + ".xml");
            log.addHandler(fileHandler);
        } catch (IOException e) {
            log.severe("can not create file handler: " + e.getMessage());
        }

        if (Boolean.valueOf(System.getProperty("debug")) != TRUE) {
            log.setLevel(OFF);
        } else {
            log.setLevel(CONFIG);
        }

        return new Logger(log);
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void warning(String msg) {
        log.warning(msg);
    }

    public void comment(String msg) {
        log.config(msg);
    }

    public void setLogLevelToAll() {
        log.setLevel(ALL);
    }
}
