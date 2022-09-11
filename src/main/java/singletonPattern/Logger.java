package singletonPattern;

import java.util.Date;

public class Logger {
    private static Logger logger;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg){
        System.out.printf("[%tc %d] %s\n", new Date(), num++, msg);
    }
}
