<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("pass");
    if (name == null && password == null) {
        name = (String) session.getAttribute("name");
        password = (String) session.getAttribute("pass");
    }
    if (name == null && password == null) {
        return;
    }
    session.setAttribute("name", name);
    session.setAttribute("pass", password);

%>

欢迎您：<%=name%>