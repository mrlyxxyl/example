<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/upload" enctype="multipart/form-data" method="post">
    file:<input type="file" name="image"/><br/>
    file1:<input type="file" name="image"/><br/>
    file2:<input type="file" name="image"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>