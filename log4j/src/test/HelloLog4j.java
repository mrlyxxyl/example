package test;

import org.apache.log4j.Logger;

public class HelloLog4j {
	private static Logger logger = Logger.getLogger(HelloLog4j.class);
	public static void main(String[] args) {
        for (int i = 0; i < 200; i++){
            logger.info("this is info message");
            logger.error("this is error message");
            logger.fatal("this is fatal message");
        }

	}
}
