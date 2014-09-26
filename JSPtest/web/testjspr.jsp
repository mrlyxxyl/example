<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <script type="text/javascript">
        function clickfun(){
            window.open("testjsprre.jsp?filename="+encodeURI(encodeURI("呵呵")));
        }
    </script>
</head>
<body>
<button onclick="clickfun();">click</button>
</body>
</html>