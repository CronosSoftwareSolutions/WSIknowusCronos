package com.iknowus.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	private static Logger log = Logger.getLogger("WebService");

	static {

		InputStream objStream = null;
		try {
			objStream = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
			if (objStream != null) {
				Properties properties = new Properties();
				properties.load(objStream);
				PropertyConfigurator.configure(properties);
				objStream.close();
				objStream = null;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (objStream != null) {
				try {
					objStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void debug(String message) {
		log.debug(message);
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void info(String message, Throwable e) {
		log.info(message, e);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void warn(String message, Throwable e) {
		log.warn(message, e);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void error(String message, Throwable e) {
		log.error(message, e);
	}
}