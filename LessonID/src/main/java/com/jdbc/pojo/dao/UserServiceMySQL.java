package com.jdbc.pojo.dao;

import com.jdbc.pojo.User;
import com.jdbc.pojo.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.Configs.*;

public class UserServiceMySQL implements UserDAO {
    private Connection getConnection(){
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("driver failed to load");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection not created");
        }
        return dbConnection;
    }

    @Override
    public void addUser(User user) {
        String sqlQuery = "INSERT INTO users (name, age, email)  VALUES (?,?,?)";
        try(Connection dbConnection = getConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getAge());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User>users = new ArrayList<>();
        String sqlQuery = "SELECT id, name, age, email FROM users";
        try(Connection dbConnection = getConnection();
            Statement statement = dbConnection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getByIdUser(int id) {
       User user = new User();
        String sqlQuery =   "SELECT id, name, age, email FROM users WHERE id=?";
        try(Connection dbConnection = getConnection();
            PreparedStatement preparedStatement =dbConnection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setName(resultSet.getString("name"));
                user.setAge((resultSet.getInt("age")));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }

    @Override
    public void removeUserById(int id) {
        String sqlQuery = "DELETE FROM users WHERE id=?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
