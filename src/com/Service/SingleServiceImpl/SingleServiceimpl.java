package com.Service.SingleServiceImpl;

import com.Dao.SingleDaoImpl.SingleDaoimpl;
import com.Entity.single;
import com.Service.SingleService;

import java.util.List;

public class SingleServiceimpl implements SingleService {
    //声明singledao层实例化类的对象，便于使用其方法
    SingleDaoimpl singleDaoimpl=new SingleDaoimpl();
    @Override
    public List<single> querySingle() {
        return singleDaoimpl.querySingle();
    }

    //获取单一科目试题的方法
    @Override
    public List<single> queryBypaper(String paper) {
        return singleDaoimpl.queryBypaper(paper);
    }
    //获取科目列表
    @Override
    public List<String> queryBySubject() {
        return singleDaoimpl.querBySubject();
    }

    @Override
    public List<String> queryAnswer(String paper) {
        return singleDaoimpl.queryAnswer(paper);
    }


}
