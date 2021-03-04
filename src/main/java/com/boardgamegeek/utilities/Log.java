package com.boardgamegeek.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Log {

    public static Logger logger = LogManager.getLogger(Log.class);

    public static synchronized void logInfo(String string) {
        logger.info(string);
    }

}
