<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = request.getParameter("name");
    if (name != null) {
        session.setAttribute("name", name);
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="#" method="post">
    <input type="text" name="name"/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>