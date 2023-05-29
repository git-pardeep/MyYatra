package com.yatra.utilities;

import org.apache.log4j.Logger;

public class Log {
	public static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTest(String sTestCaseName) {
		log.info("==========================" + sTestCaseName + "StartTest==================");
	}

	public static void endTest(String sTestCaseName) {
		log.info("==========================" + sTestCaseName + "EndTest==================");
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}
}