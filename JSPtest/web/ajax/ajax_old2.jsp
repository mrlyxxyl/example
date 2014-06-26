<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = new String(request.getParameter("name").getBytes("iso8859-1"), "UTF-8");

    out.print("您好：" + name);

%>