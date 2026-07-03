package com.tap.Utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/instant_food?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static String PASSWORD;

    private static Connection con;

    // Load password from password.properties
    static {
        try {
            Properties properties = new Properties();

            InputStream input = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("password.properties");

            if (input == null) {
                throw new RuntimeException("password.properties not found");
            }

            properties.load(input);

            PASSWORD = properties.getProperty("db.password");

            input.close();

        } catch (Exception e) {
            throw new RuntimeException("Unable to load password.properties", e);
        }
    }

    public static Connection getConnection() {

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Database Connected Successfully!");

        } catch (ClassNotFoundException e) {

            System.out.println("❌ MySQL Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
        }

        return con;
    }
}