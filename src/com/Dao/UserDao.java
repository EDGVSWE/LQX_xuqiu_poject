package com.Dao;

import com.Entity.User;

public interface UserDao {
    String  queryByUserName(String username);

    void insert(User user);
}
