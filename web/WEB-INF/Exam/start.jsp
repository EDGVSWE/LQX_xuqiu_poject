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


    <form action="<%=path%>singleservlet?method=getsubjectList" method="post">
        <button type="submit">开始考试</button>
    </form>
</center>

</body>
</html>
