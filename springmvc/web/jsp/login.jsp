<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-9-26
  Time: 上午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/User/checkLogin.do" method="post">
    姓名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>