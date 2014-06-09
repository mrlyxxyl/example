<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ page import="com.lowagie.text.Document" %>
<%@ page import="com.lowagie.text.Paragraph" %>
<%@ page import="com.lowagie.text.pdf.PdfWriter" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.DataOutput" %>
<%@ page import="java.io.DataOutputStream" %>


<%
    response.setContentType("application/pdf");
    Document doc = new Document();
    ByteArrayOutputStream ba = new ByteArrayOutputStream();

    PdfWriter writer = PdfWriter.getInstance(doc, ba);
    doc.open();
    doc.add(new Paragraph("Hello World"));
    doc.close();

    DataOutput output = new DataOutputStream(response.getOutputStream());
    byte[] bytes = ba.toByteArray();
    response.setContentLength(bytes.length);
    for (int i = 0; i < bytes.length; i++) {
        output.writeByte(bytes[i]);
    }
%>  
