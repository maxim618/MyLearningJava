package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static com.jdbc.Configs.*;
import static com.jdbc.Const.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        final String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        String id = "11";
        String name = "Iren";
        String age = "25";
        String email = "iren@gmail.com";
        System.out.println(connectionString);


        try( Connection dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);){
            Class.forName("com.mysql.cj.jdbc.Driver");


           /* String insert = String.format("INSERT INTO %s (%s, %s, %s)  VALUES (?,?,?)",
                    USER_TABLE,
                    USER_NAME,
                    USER_AGE,
                    USER_EMAIL);
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insert);

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,age);
            preparedStatement.setString(3,email);

            preparedStatement.executeUpdate();
             */





        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

    }
}
