package org.TodoApp.com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    private static Connection con = null;

    static {
        String userName = "root";
        String userPass = "password";

        String url = "jdbc:mysql://127.0.0.1:3306/todoit";
        try{
            con = DriverManager.getConnection(url, userName, userPass);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            //todo throw a custom exception
        }


    }
    public static Connection getDbConnection(){
        return con;
    }
}
