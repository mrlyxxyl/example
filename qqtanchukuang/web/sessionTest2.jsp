<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String name = (String) session.getAttribute("name");
    String sid = session.getId();
    Integer age = (Integer) application.getAttribute("age");
    String url = response.encodeURL("http://www.baidu.com");
%>

<%=name%>
<%=sid%>
<%=age%>
<%=url%>