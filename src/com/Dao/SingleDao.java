package com.Dao;

import com.Entity.single;

import java.util.List;

public interface SingleDao {
    //全查询single表
   public List<single> querySingle();

    List<single> queryBypaper(String paper);

    List<String> querBySubject();


    List<String> queryAnswer(String paper);
}
