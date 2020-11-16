<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/10/28
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%--引入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String path=request.getContextPath()+"/"; %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="<%=path%>js/jquery.js"></script>
<body>
<%--c:forEach类似与增强for循环，items类似需要循环的集合，var表示循环指针，所有从后端传给前端的参数均是${变量名（key）}--%>
<form action="<%=path%>singleservlet?method=checkTest" method="post">
<%--    隐式提交科目名--%>
    <input type="hidden" name="paper" value="${paper}">
<c:forEach items="${paperList}" var="i" varStatus="status">
<%--    varStatus="status"表示为当前循环添加计数器，用于直观表示当前指针绝对位置--%>
    <p>当前题目名为：${i.subject}</p>
    <p><input type="radio" name="${status.index}" value="A">${i.option_A}</p>
    <p><input type="radio" name="${status.index}" value="B">${i.option_B}</p>
    <p><input type="radio" name="${status.index}" value="C">${i.option_C}</p>
    <p><input type="radio" name="${status.index}" value="D">${i.option_D}</p>
</c:forEach>
<%--    获取paperList总长度--%>
    <button type="button" onclick="check(${fn:length(paperList)})">交卷</button>
</form>

</body>
    <script>
        function check(length) {
            //检测是否作答完毕
            var flag=true;
            for(var i=0;i<length;i++){
                //取出选项的值,并判断是否被选中
                //"i"
                if($("input[name="+i+"]:checked").val()==undefined){
                    flag=false;
                    // break;
                }
            }
            if(flag){
                $("form").submit();
            }
            else{
                alert("您未作答完毕");
            }

    }
</script>
</html>
