<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    out.write(String.valueOf(request.getRemoteHost()));
    out.write("<br/>");
    out.write(request.getRemotePort() + "");
%>
