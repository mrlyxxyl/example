import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CallDll {
    public static void main(String args[]) {
        ActiveXComponent app = new ActiveXComponent("shuikong.skfun");   //PrntInterface.PrntCom.1
        Dispatch mycom = app.getObject();
        String strInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<InvInfo>" +
                "<InvType>1</InvType>" +
                "<PayClient Name=\"测试付款单位\" ConUser=\"gdma\" CardNo=\"26878833\" Tel= \"8886533\" TaxNo=\"123456\" ProxyNo = \"sn1733\"/> " +
                "<fadeInv InvCode=\"10000000010000000002\" InvNo=\"55555015\" /> " +
                "<Item name=\"卫生间\" month=\"20070811\" num=\"29935\" price=\"2.8\"  cash=\"83818\" taxItem=\"1\" exattrib1=\"\", exattrib2=\"\", exattrib3=\"\", exattrib4=\"\"/> " +
                "<TradeData name=\"BUS_REMARK\" data=\"Hello 自来水这是备注\"/>" +
                "" +
                "</InvInfo>";
        String strInput2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<InvInfo>" +
                "<Version>1.00000</Version>" +
                "<InvType>1</InvType>" +
                "<PayClient Name=\"测试付款单位\" ConUser=\"gdm\" CardNo=\"26878880\" Tel= \"8886577\" TaxNo=\"26878880\" ProxyNo = \"sn1786\"/> " +
                //"<QueryInv InvCode=\"00000000000000000001\" InvNo=\"00000014\" /> " +
                "<fadeInv InvCode=\"10000000010000000000\" InvNo=\"456\" /> " +
                "<Item name=\"厨房\" month=\"200711\" num=\"1\" price=\"100000000\"  cash=\"100000000\" taxItem=\"1\" exattrib1=\"1\", exattrib2=\"2\", exattrib3=\"3\", exattrib4=\"4\"/> " +
                  "<TradeData name=\"BUS_REMARK\" data=\"Hello 自来水\"/>" +
                "<TradeData name=\"BUS_CLIENT_ADDR\" data=\"海淀区杏石口路甲18号\"/>" +
                "<TradeData name=\"BUS_BILLING_CYCLE\" data=\"3\"/>" +
                "<TradeData name=\"BUS_QUOTA\" data=\"3\"/>" +
                "<TradeData name=\"BUS_POPULATION\" data=\"3\"/>" +
                "<TradeData name=\"BUS_CONSUMPTION\" data=\"15\"/>" +
                "<TradeData name=\"BUS_HOUSE_NUMBER\" data=\"12456\"/>" +
                "<TradeData name=\"BUS_REMITTING\" data=\"123456\"/>" +
                "<TradeData name=\"BUS_BUSKIND\" data=\"自来水\"/>" +
                "<TradeData name=\"BUS_PAYEE\" data=\"测试收款人\"/>" +
                "</InvInfo>";
        String strInput3 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<InvInfo>" +
                "<Version>1.00000</Version>" +
                "<InvType>1</InvType>" +
                "<PayClient Name=\"测试付款单位\" ConUser=\"gdm\" CardNo=\"26878880\" Tel= \"8886577\" TaxNo=\"26878880\" ProxyNo = \"sn1786\"/> " +
                "<fadeInv InvCode=\"10000000000000000001\" InvNo=\"00000018\" /> " +
                "<Item name=\"大米\" num=\"5000.00\" price=\"1\"  cash=\"5000\" taxItem=\"1\" exattrib1=\"\", exattrib2=\"\", exattrib3=\"\", exattrib4=\"\"/> " +
                "<TradeData name=\"BUS_RANK\" data=\"A级\"/>" +
                "<TradeData name=\"BUS_WATER\" data=\"30\"/>" +
                "<TradeData name=\"BUS_INCLUSION\" data=\"40\"/>" +
                "<TradeData name=\"BUS_ASSAY_BILLNO\" data=\"123456789ABCD\"/>" +
                "<TradeData name=\"BUS_CAR_KIND\" data=\"车种\"/>" +
                "<TradeData name=\"BUS_SCATTERED_SIZE\" data=\"100\"/>" +
                "<TradeData name=\"BUS_BAG_SIZE\" data=\"60\"/>" +
                "<TradeData name=\"BUS_TOTAL_WEIGHT\" data=\"1000斤\"/>" +
                "<TradeData name=\"BUS_TARE\" data=\"1005斤\"/>" +
                "<TradeData name=\"BUS_INCLUSION_WEIGHT\" data=\"2斤\"/>" +
                "<TradeData name=\"BUS_NT_WEIGHT\" data=\"1000斤\"/>" +
                "<TradeData name=\"BUS_ADD_WEIGHT\" data=\"5斤\"/>" +
                "<TradeData name=\"BUS_DEDUCT_WEIGHT\" data=\"5斤\"/>" +
                "<TradeData name=\"BUS_PURE_WEIGHT\" data=\"5000斤\"/>" +
                "<TradeData name=\"BUS_QUALITY_CHECKER\" data=\"三三\"/>" +
                "<TradeData name=\"BUS_SETTLE_MAN\" data=\"四四\"/>" +
                "<TradeData name=\"BUS_PAYER_MAN\" data=\"五五\"/>" +
                "<TradeData name=\"BUS_INPUT_MAN\" data=\"六六\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_NAME1\" data=\"自定义1\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_VALUE1\" data=\"selfdef1\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_NAME2\" data=\"自定义2\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_VALUE2\" data=\"selfdef2\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_NAME3\" data=\"自定义3\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_VALUE3\" data=\"selfdef3\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_NAME4\" data=\"自定义4\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_VALUE4\" data=\"selfdef4\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_NAME5\" data=\"自定义5\"/>" +
                "<TradeData name=\"BUS_SELT_DEF_VALUE5\" data=\"selfdef5\"/>" +
                "<TradeData name=\"BUS_CAR_NO\" data=\"123456\"/>" +
                "<TradeData name=\"BUS_CHECK_WEIGHT\" data=\"七七\"/>" +
                "<TradeData name=\"BUS_REMARK\" data=\"这是备注\"/>" +
                "</InvInfo>";
        if (mycom != null) {


//            Variant dd = Dispatch.callN(mycom,"GetErrInfExt");
//            Variant vvv = Dispatch.callN(mycom, "GetInterfaceState");
//            Variant result = Dispatch.callN(mycom, "PreviewInv");//预览发票信息
//            System.out.println(vvv);
            //Variant result1 = Dispatch.callN(mycom, "GetVersion"); //获取版本信息
            Variant result = Dispatch.callN(mycom, "PrntInv", new Variant(strInput2));  //打印发票
//            Variant result3 = Dispatch.callN(mycom, "GetCurInv"); //获取当前发票信息还未打印
//            Variant result4 = Dispatch.callN(mycom, "GetPrntReturnData"); //获取打印返回数据
            System.out.println(result);
            // System.out.println(result2);
            // System.out.println(result3);
            // System.out.println(result4);
        }
    }
}
