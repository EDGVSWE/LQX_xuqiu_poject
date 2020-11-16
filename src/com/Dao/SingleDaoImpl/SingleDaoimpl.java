package com.Dao.SingleDaoImpl;

import com.Dao.SingleDao;
import com.Entity.single;
import com.Util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SingleDaoimpl implements SingleDao {
    //使用JDBCTemplate工具类，目的与数据库完成链接
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<single> querySingle() {
        /**第一步：声明sql语句
         * 第二步：使用sql语句，并将结果转化为相应的Entity类
         */
        String sql="SELECT * FROM single ;";
// return jdbcTemplate.queryForList(sql,single.class);
// return jdbcTemplate.queryForList(sql,new BeanPropertyRowMapper<single>());
        //?表示占位符，即所传递的变量，在sql中替换？
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(single.class));
    }

    @Override
    public List<single> queryBypaper(String paper) {
        /**
         * 1.声明sql语句
         * 2.使用sql语句，并返回结果
         * ?表示占位符，java运行到执行该sql语句时，会将我们的？替换为相应的内容（paper），意义使sql语句动态化
         * dbcTemplate.query(sql,new BeanPropertyRowMapper<>(single.class),paper);
         * dbcTemplate.query(sql语句，快速生成对应实体类(com.Entity)对象，取代（替换)？(预占位符))
         */
         String sql="SELECT * from single where paper= ? ";
         return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(single.class),paper);
    }

    @Override
    public List<String> querBySubject() {
        /**第一步：声明sql语句
         * 第二步：使用ql语句，并将结果转化为相应的Entity类
         */
        String sql="SELECT DISTINCT paper FROM single";
        //queryForList 可以直接将sql查询的结果集整理为基本类型（String）的集合
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> queryAnswer(String paper) {
        /**
         * 第一步：声明sql语句
         * 第二部：使用sql语句，并将结果转化为相应的Entity类
         */
        String sql="SELECT answer from single where paper=?";
        return jdbcTemplate.queryForList(sql,String.class,paper);
    }


}
