<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        FileOutputStream fos = new FileOutputStream("f:/text.txt");
        InputStream is = request.getInputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = is.read(buff)) > 0) {
            fos.write(buff, 0, len);
        }
        fos.flush();
        fos.close();

%>