<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath() + "/";
%>
<%--获取静态上下文，既绝对路径--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <center>
<form action="<%=path%>userServlet?method=login" method="post">
  <input type="text" name="username" value="" placeholder="请输入用户名">
  <input type="text" name="password" value="" placeholder="请输入密码">
  <button type="submit">Login</button>
</form>

    <a href="<%=path%>register.jsp">注册</a>

  </center>

  </body>
</html>
