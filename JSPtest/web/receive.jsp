<%@ page import="java.io.FileOutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //Content-Disposition: form-data; name="filename"; filename="lock.png"
    byte[] buffer = new byte[1024];
    String fileName = "";
    int len;
    while ((len = request.getInputStream().readLine(buffer, 0, 1024)) > 0) {
        String tmp = new String(buffer, 0, len);
        if (tmp.contains("filename=")) {
            fileName = tmp.substring(tmp.indexOf("filename=") + 10, tmp.lastIndexOf('\"'));
            request.getInputStream().readLine(buffer, 0, 1024);
            request.getInputStream().readLine(buffer, 0, 1024);
            break;
        }
    }
    FileOutputStream fos = new FileOutputStream("f:/" + fileName);
    int length;
    while ((length = request.getInputStream().readLine(buffer, 0, 1024)) > 0) {
        String tmp = new String(buffer,0,length);
        if (tmp.startsWith("-----------------------------")) {
            break;
        }
        fos.write(buffer, 0, length);
    }
    fos.flush();
    fos.close();

%>