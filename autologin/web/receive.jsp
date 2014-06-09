<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="bean.Person">
    <jsp:setProperty name="person" property="*"/>
</jsp:useBean>
${person.username}
${person.age}
${person.addr}
${person.sex}
${person.birthday}

