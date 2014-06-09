<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) session.getAttribute("name");
    String password = (String) session.getAttribute("pass");
    if (name != null && password != null) {
        if (name.equals("nanmeiying") && password.equals("adminroot88")) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            return;
        }
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="welcome.jsp" method="post">
    NAME:<input type="text" name="name"><br/>
    PASS:<input type="text" name="pass"><br/>
    <input type="submit" value="login">
</form>
</body>
</html>