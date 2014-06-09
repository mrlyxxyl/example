<%@ page import="java.net.Socket" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.net.DatagramPacket" %>
<%@ page import="java.net.InetSocketAddress" %>
<%@ page import="java.net.DatagramSocket" %>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%
    String hostVar = request.getParameter("host");
    String p = request.getParameter("port");
    int portVar = Integer.parseInt(p);
    byte[] buff = "hello world!".getBytes();
    DatagramPacket dp = new DatagramPacket(buff, buff.length, new InetSocketAddress(hostVar, portVar));
    DatagramSocket ds = new DatagramSocket(9999);
    ds.send(dp);
    ds.close();
%>