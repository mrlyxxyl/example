<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url = "http://www.baidu.com" + session.getId();
    request.setAttribute("url", url);
%>

${url}