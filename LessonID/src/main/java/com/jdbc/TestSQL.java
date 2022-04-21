package com.jdbc;

import com.jdbc.pojo.User;
import com.jdbc.pojo.dao.UserServiceMySQL;

import java.util.List;

public class TestSQL {
    public static void main(String[] args) {

        User user = new User(10,"Martin",100,"martin@gmail.com");
        //new UserServiceMySQL().addUser(user);
        //new UserServiceMySQL().removeUserById(11);
        List<User>userList = new UserServiceMySQL().getAllUser();
        for(User u:userList){
            System.out.println(u.toString());
        }
    }
}
