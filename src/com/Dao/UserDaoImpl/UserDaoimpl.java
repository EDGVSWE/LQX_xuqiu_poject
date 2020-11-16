package com.Dao.UserDaoImpl;

import com.Dao.UserDao;
import com.Entity.User;
import com.Util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoimpl implements UserDao {
    //使用JDBCTemplate工具类，目的与数据库完成链接
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public String queryByUserName(String username) {
        //声明sql
        //调用sql，并返回数据
        String sql="SELECT password FROM user where username=?";
        return jdbcTemplate.queryForObject(sql,String.class,username);
    }

    @Override
    public void insert(User user) {
        //声明sql
        //调用sql，并返回数据
      String sql="INSERT into user(username,password,name,telephone,sex,age,role ) VALUES(?,?,?,?,?,?,?);";
      jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),user.getSex(),user.getAge(),user.getRole());
    }
}

