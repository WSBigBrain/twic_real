package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.config.JDBCConfiguration;

@Configuration
public class DaoFactory {

	private static String url="jdbc:mysql://localhost:3307/twic";
    private static String username="root";
    private static String password="root";
    private static Connection connection=null;

    DaoFactory() {
    }
	

	@Bean
	public Connection getConnection() throws SQLException {
		connection= DriverManager.getConnection(url, username, password);		
		return connection;
	}
	
	public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        DaoFactory instance = new DaoFactory();
        return instance;
	}

}
