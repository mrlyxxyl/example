<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String filename = request.getParameter("filename");
    filename = URLDecoder.decode(filename,"utf-8");
    out.print(filename);
%>