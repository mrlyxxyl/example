<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/validate_update" method="post">
    <table>
        <tr>
            <td style="text-align: right;">username:<input type="text" name="username"/></td>
            <td style="text-align: left;"><s:fielderror fieldName="username"/></td>
        </tr>

        <%-- <tr>
             <td style="text-align: right;">birthday:<input type="text" name="birthday"/></td>
             <td style="text-align: left;"><s:fielderror fieldName="birthday"/></td>
         </tr>--%>
        <tr>
            <td style="text-align: right;">mobile:<input type="text" name="mobile"/></td>
            <td style="text-align: left;"><s:fielderror fieldName="mobile"/></td>
        </tr>
    </table>
    <input type="submit" value="提交">

</form>

</body>
</html>