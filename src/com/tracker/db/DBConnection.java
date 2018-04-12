package com.tracker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static final String URL = "jdbc:mysql://localhost/tracker";
    public static final String USER = "tracker";
    public static final String PASSWORD = "password";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 

	private static DBConnection instance = new DBConnection();

    //private constructor
    private DBConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
	private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
	}

    public static Connection getConnection() {
        return instance.createConnection();
    }

}
