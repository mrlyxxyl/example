<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String time = System.currentTimeMillis() + "";
    String serverInfo = (String) request.getServletContext().getAttribute("time");
    String clientInfo = (String) session.getAttribute("time");
    if (clientInfo == null) {
        clientInfo = time;
        session.setAttribute("time", time);
    }
    if (serverInfo == null) {
        request.getServletContext().setAttribute("time", time);
        session.setAttribute("time", time);
    } else {
        if (!clientInfo.equals(serverInfo)) {
            request.getServletContext().setAttribute("time", time);
        }
    }

%>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        var int = setInterval("checkLogin()", 5000);
        function checkLogin() {
            var servI = "<%=(String) request.getServletContext().getAttribute("time")%>";
            var clieI = "<%=(String) session.getAttribute("time")%>";
            alert(servI + "---" + clieI);
        }
    </script>
</head>
<body>

</body>
</html>