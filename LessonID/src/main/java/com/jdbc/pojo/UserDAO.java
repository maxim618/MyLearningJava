package com.jdbc.pojo;

import java.util.List;

public interface UserDAO {

    void addUser (User user);
    List<User> getAllUser();
    User getByIdUser(int id);
    void removeUserById (int id);
}
