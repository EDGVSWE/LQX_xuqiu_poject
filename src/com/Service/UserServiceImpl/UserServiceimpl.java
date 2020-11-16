package com.Service.UserServiceImpl;

import com.Dao.UserDao;
import com.Dao.UserDaoImpl.UserDaoimpl;
import com.Entity.User;
import com.Service.UserService;

public class UserServiceimpl implements UserService {
    //UserDao 对象
    UserDao userDao=new UserDaoimpl();
    @Override
    public String queryByUserName(String username) {
        return userDao.queryByUserName(username);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}
