package com.iknowus.data;

import java.sql.Connection;
import java.sql.DriverManager;

import com.iknowus.App;
import com.iknowus.util.Configuration;

public class Pool {
	private transient static Connection connection = null;

	public static Connection getConnection() throws Exception {
		Configuration config = new Configuration();
//		String strUrl = "jdbc:mysql://" + config.get("db.server") + ":" + config.get("db.port") + "/" + config.get("db.name");
		String strUrl = "jdbc:mysql://" + App.DATABASE_SERVER + ":" + App.DATABASE_PORT + "/" + App.DATABASE_NAME;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		connection = DriverManager.getConnection(strUrl, config.get("db.user"), config.get("db.password"));
		connection = DriverManager.getConnection(strUrl, App.DATABASE_USER, App.DATABASE_PASSWORD);
		return connection;
	}

}
