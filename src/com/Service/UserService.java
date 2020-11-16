package com.Service;

import com.Entity.User;

public interface UserService {
    String queryByUserName(String username);

    void insert(User user);
}
