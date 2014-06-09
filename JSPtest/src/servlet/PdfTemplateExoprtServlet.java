package servlet;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-13
 * Time: ����1:04
 * To change this template use File | Settings | File Templates.
 */
public class PdfTemplateExoprtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String tempPath = this.getServletContext().getRealPath("template/tmp.pdf");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfReader pdf = new PdfReader(new FileInputStream(tempPath));   //�����ļ�
            PdfStamper stamp = new PdfStamper(pdf, baos);//ȡ��ͼ�¶���
            AcroFields form = stamp.getAcroFields(); //ȡ�������ֶ�
            form.setField("jid", "jid");   //��д����
            /*form.setField("bid", "���ź�");   //��д����
            form.setField("id", "�˺�");   //��д����
            form.setField("name", "����");   //��д����
            form.setField("date", "��������");   //��д����
            form.setField("pl", "����");   //��д����
            form.setField("name", "����Ա");   //��д����*/
            stamp.setFormFlattening(true);    //��ӡ��

            //��ʱ��PDF������д�Ѿ���ɣ�����������ˮӡ�����棬Ӧ����ͼ�¹ر�ǰִ�����´��롣
            /*int total = pdf.getNumberOfPages() + 1;    //ȡҳ��
            Image image = Image.getInstance(getServletContext().getRealPath("xiezhen.jpg"));  // ׼��ͼƬ
            image.setAbsolutePosition(0, 0);//λ��
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.5f);//͸����
            PdfContentByte over;
            for (int i = 1; i < total; i++) {
                over = stamp.getUnderContent(i);
                over.addImage(image);
                over.setGState(gs);
            }*/

            stamp.close();//�ر�ͼ��
            ServletOutputStream sos = response.getOutputStream();
            response.setContentType("text/xml;charset=UTF-8");
            response.addHeader("Content-Disposition", "attachment; filename=testpdfExport.pdf");
            response.setContentType("application/pdf");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.addHeader("Content-Length", Integer.toString(baos.size()));
            baos.writeTo(sos);
            sos.flush();
            sos.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
