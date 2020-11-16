package com.Controller;

import com.Entity.User;
import com.Service.UserService;
import com.Service.UserServiceImpl.UserServiceimpl;
import com.Util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {
    //生成服务对象
    UserService userService=new UserServiceimpl();
    public String login(HttpServletRequest request,HttpServletResponse response){
       //接收请求，调用服务，跳转界面
        String username=request.getParameter("username");
        String userPassword=request.getParameter("password");
        //调用服务，取出对应用户名的正确密码
        String password=userService.queryByUserName(username);
        //判断密码是否一致
        if(password.equals(userPassword)){
            return "WEB-INF/Exam/start.jsp";
        }
        //登录失败，仍在原界面
        return "index.jsp";
    }
    public  String register(HttpServletRequest request,HttpServletResponse response){
        //接收请求，调用服务，跳转界面
        //将前端的数据整合在一个user对象中
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setAge(request.getParameter("age"));
        user.setSex(request.getParameter("sex"));
        user.setRole(request.getParameter("role"));
        user.setTelephone(request.getParameter("telephone"));
        //调用服务
        userService.insert(user);
        //跳转界面
        return "index.jsp";
    }
}
