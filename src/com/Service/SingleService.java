package com.Service;

import com.Entity.single;

import java.util.List;

public interface SingleService {
    //与Dao层一致，表示查询single表全部内容
    public List<single> querySingle();

    List<single> queryBypaper(String paper);

    List<String>  queryBySubject();

    List<String> queryAnswer(String paper);
}
