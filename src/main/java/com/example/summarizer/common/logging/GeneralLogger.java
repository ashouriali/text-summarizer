package com.example.summarizer.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralLogger {
    private Logger logger;
    private GeneralLogger() {}
    public GeneralLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }
}
