<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String id = "";
    String name = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        String cookieName = cookie.getName();
        String cookieValue = cookie.getValue();
        if ("id".equals(cookieName)) {
            id = cookieValue;
        } else if ("name".equals(cookieName)) {
            name = cookieValue;
        }
    }
%>

<form method="post" action="/jsptest/servlet/TestCookieServlet">
    <input name="id" type="text" value="<%=id%>"><br/>
    <input name="name" type="text" value="<%=name%>"><br/>
    <input type="submit" value="click"/>
</form>