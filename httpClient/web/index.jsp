<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String name = request.getParameter("name");
    if ("nanmeiying".equals(name)) {
        out.print("hello nanmeiying" + new Date().toString());
    } else {
        out.print("error" + new Date().toString());
    }
%>
</body>
</html>