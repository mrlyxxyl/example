<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        setInterval("showTime()", 1000);
        function showTime() {
            var d = new Date();
            document.getElementById("time").value = d.toLocaleString();
        }
    </script>
</head>
<body>
<input id="time" type="text" style="width: 300px;"/>
</body>
</html>