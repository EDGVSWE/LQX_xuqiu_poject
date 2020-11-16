<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/10/29
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%--引入JSTL标签库--%>
<%
    String path = request.getContextPath() + "/";
%>
<%--获取静态上下文，既绝对路径--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--&lt;%&ndash;用户输入科目名，提交需求&ndash;%&gt;--%>
<%--<form action="<%=path%>singleservlet?method=getParperList" method="post">--%>
<%--    &lt;%&ndash;    输入科目&ndash;%&gt;--%>
<%--    <input type="text" name="paper" value="">请输入科目名--%>
<%--    <button type="submit">提交</button>--%>
<%--</form>--%>
<%--用户选择科目名--%>
<form action="<%=path%>singleservlet?method=getParperList" method="post">
    <c:forEach items="${subjectList}" var="i">
        <input type="submit" value="${i}" name="paper">
    </c:forEach>
</form>

</body>
</html>
