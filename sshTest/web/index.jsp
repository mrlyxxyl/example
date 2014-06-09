<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/index_save" method="post">
    <table>
        <tr>
            <td>username:<input type="text" name="username"/></td>
            <td><s:fielderror/> ${saveSuccess}</td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>

<a href="${pageContext.request.contextPath}/test/index_getPerson">检索</a>
<hr/>
<s:iterator value="#request.persons" var="person">
    <s:property value="#person.id"/> ---- <s:property value="#person.name"/><br/>
</s:iterator>
</body>
</html>