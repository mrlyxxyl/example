package action;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class StudyJacob {
    // ����һ��word����
    private ActiveXComponent objWord;

    // �����ĸ�word���
    private Dispatch custDocprops;

    private Dispatch builtInDocProps;


    private Dispatch document;

    private Dispatch wordObject;


    public StudyJacob() {
    }

    /**
     * ��word�ĵ�
     */
    public void open(String filename) {
        // ����һ��word����
        objWord = new ActiveXComponent("Word.Application");

        // Ϊwordobject�����ֵ
        wordObject = (Dispatch) (objWord.getObject());            // ��������

        // ����һ��ֻ����ʽ��word�ĵ����
        Dispatch.put(wordObject, " Visible ", new Variant(false));

        // ��ȡ�ĵ�����
        Dispatch documents = objWord.getProperty(" Documents ").toDispatch();

        // �򿪼����ĵ�
        document = Dispatch.call(documents, " Open ", filename).toDispatch();
    }


    public void selectCustomDocumentProperitiesMode() {

        custDocprops = Dispatch.get(document, " CustomDocumentProperties ")
                .toDispatch();
    }


    public void selectBuiltinPropertiesMode() {

        builtInDocProps = Dispatch.get(document, " BuiltInDocumentProperties ")
                .toDispatch();
    }

    /**
     * �ر��ĵ�
     */
    public void close() {

        Dispatch.call(document, " Close ");
    }


    public String getCustomProperty(String cusPropName) {
        try {
            cusPropName = Dispatch.call((Dispatch) custDocprops, " Item ",
                    cusPropName).toString();
        } catch (ComException e) {

            cusPropName = null;
        }

        return cusPropName;
    }

    public String getBuiltInProperty(String builtInPropName) {
        try {
            builtInPropName = Dispatch.call((Dispatch) builtInDocProps, " Item ",
                    builtInPropName).toString();
        } catch (ComException e) {

            builtInPropName = null;
        }

        return builtInPropName;
    }


    public static void main(String[] args) {
        try {

            StudyJacob jacTest = new StudyJacob();


            jacTest.open("f:/test.doc ");


            jacTest.selectCustomDocumentProperitiesMode();


            jacTest.selectBuiltinPropertiesMode();


            String custValue = jacTest.getCustomProperty(" Information Source ");


            String builtInValue = jacTest.getBuiltInProperty(" Author ");


            jacTest.close();


            System.out.println(" Document Val One:  " + custValue);
            System.out.println(" Document Author:  " + builtInValue);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}