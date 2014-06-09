package servlet;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReportPdfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportPdfServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Document doc = new Document();
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, ba);
            doc.open();
            doc.add(new Paragraph("Hello World"));

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        doc.close();

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=test.pdf");
        response.setContentLength(ba.size());
        ServletOutputStream out = response.getOutputStream();
        ba.writeTo(out);
        out.flush();
    }
}

