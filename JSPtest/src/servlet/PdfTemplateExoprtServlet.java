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
 * Time: 下午1:04
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
            PdfReader pdf = new PdfReader(new FileInputStream(tempPath));   //读入文件
            PdfStamper stamp = new PdfStamper(pdf, baos);//取得图章对象
            AcroFields form = stamp.getAcroFields(); //取出所有字段
            form.setField("jid", "jid");   //填写内容
            /*form.setField("bid", "部门号");   //填写内容
            form.setField("id", "账号");   //填写内容
            form.setField("name", "姓名");   //填写内容
            form.setField("date", "开户日期");   //填写内容
            form.setField("pl", "姓名");   //填写内容
            form.setField("name", "交易员");   //填写内容*/
            stamp.setFormFlattening(true);    //盖印表单

            //此时，PDF内容填写已经完成，但如果你想加水印在上面，应该在图章关闭前执行以下代码。
            /*int total = pdf.getNumberOfPages() + 1;    //取页数
            Image image = Image.getInstance(getServletContext().getRealPath("xiezhen.jpg"));  // 准备图片
            image.setAbsolutePosition(0, 0);//位置
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.5f);//透明度
            PdfContentByte over;
            for (int i = 1; i < total; i++) {
                over = stamp.getUnderContent(i);
                over.addImage(image);
                over.setGState(gs);
            }*/

            stamp.close();//关闭图章
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
