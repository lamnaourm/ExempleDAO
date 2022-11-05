package com.ismo.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class SingletonConnection {

	private static Connection connection = null;
	
	private SingletonConnection() {
		
	}
	
	public static synchronized Connection getInstance() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		if(connection==null) {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/com/ismo/connection/db.properties"));
			
			Class.forName(prop.getProperty("driver"));
			
			connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),prop.getProperty("pwd"));		
		}
		
		return connection;
	}
}
