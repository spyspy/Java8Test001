package annotation;

import java.util.logging.Logger;

public class SysLogMain {
    private static final Logger logger = Logger.getLogger(SysLogMain.class.getName());

    @SysLog(des = "This is a log event")
    public static void main(String[] args) {
        logger.info("Custom log message: " + "This is a sample log message");

    }
}
