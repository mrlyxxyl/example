<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    request.setAttribute("user", "nanmeiying");
%>
${message}<br/>

<s:property value="message"/><br/>
${requestScope.req} <br/>
<s:property value="#request.req"/><br/>
${sessionScope.ses}<br/>
<s:property value="#session.ses"/> <br/>
${applicationScope.app}<br/>
<s:property value="#application.app"/> <br/>
<s:date name="birthday" format="yyyy-MM-dd"/> <br/>


<s:checkboxlist name="list" list="list" value="{'yi','er'}"/>

<s:radio list="list" name="radiolist" value="{'',''}"/>