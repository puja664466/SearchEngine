package com.Accio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static Connection connection = null;
    static Connection getConnection(){
        if(connection != null)
        {
            return connection;
        }
        String user = "root";
        String pwd = "Puja@123";
        String db = "searchengineapp";
        return getConnection(user, pwd,db);
    }
    static Connection getConnection(String user, String pwd, String db)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db + "?user=root&password=Puja@123");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}







