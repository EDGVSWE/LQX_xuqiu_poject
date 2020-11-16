package com.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取用户指定的方法
        String method=req.getParameter("method");
        //获取当前servlet类
        Class servlet=this.getClass();
        Method method1;
        //在当前servlet类中找到用户指定的方法
        try {
            method1=servlet.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("对不起，没有找到当前方法");
        }
        String jspPage;
        //调用对应方法
        try {
            jspPage=(String) method1.invoke(this,req,resp);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("执行错误");
        }
        req.getRequestDispatcher(jspPage).forward(req,resp);
    }
}
