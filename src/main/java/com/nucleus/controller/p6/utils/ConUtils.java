package com.nucleus.controller.p6.utils;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

public class ConUtils {

    public static String dbName;
    public static String dbUsername;
    public static String dbUserpwd;
    public static String dbLoc;
    private static Connection connection =null;

    //Using properties file to store the database connection details

    public static  void loadConfig(){

        Properties properties = new Properties();

        try(FileReader fileReader = new FileReader("C:\\Users\\patha\\IdeaProjects\\WebDevlopment\\src\\main\\resources\\config.properties"))
        {
            properties.load(fileReader);

            dbUsername = properties.getProperty("db.username");
            dbUserpwd =  properties.getProperty("db.password");
            dbLoc = properties.getProperty("db.url");
            dbName = properties.getProperty("db.driver"); // This should be the JDBC driver class name

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Creating a connection object

    public static Connection getConnection() {

        //Load the Oracle Driver

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (connection == null) {
            loadConfig();
            try {
                connection = DriverManager.getConnection(dbLoc, dbUsername, dbUserpwd);
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
        return connection;
    }










}
