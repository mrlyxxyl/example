<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-10-2
  Time: 下午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        var thisPage = {
            toggleMsg: function () {
                $("#btn").on("click", function () {
                    $("#msg").toggle(300);
                })
            }
        }

        $(function () {
            thisPage.toggleMsg();
        })
    </script>
</head>
<body>
<button id="btn">click</button>
<div id="msg">
    hello world!
</div>
</body>
</html>