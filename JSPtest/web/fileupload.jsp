<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action="receive.jsp" enctype="multipart/form-data">
    标题：<input type="text" name="title"/> <br/>
    <input type="file" name="filename"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>