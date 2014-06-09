package com.yuexin.bean;

import java.io.Serializable;

/**
 * 发票类
 */
public class Invoice implements Serializable {
    private String id;  //单号
    private String payerName;//付款人名称
    private String vocPrice;//开票金额
    private String vocType;//开票类型
    private String exitVocCode;//退票代码
    private String exitVocNum;//退票号码
    private String voiNum;//发票号码
    private String vocState;//开票状态
    private String tradInf1;//行业信息1
    private String tradInf2;//行业信息2
    private String tradInf3;//行业信息3
    private String tradInf4;//行业信息4
    private String tradInf5;//行业信息5
    private String tradInf6;//行业信息6
    private String tradInf7;//行业信息7
    private String tradInf8;//行业信息8

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getVocPrice() {
        return vocPrice;
    }

    public void setVocPrice(String vocPrice) {
        this.vocPrice = vocPrice;
    }

    public String getVocType() {
        return vocType;
    }

    public void setVocType(String vocType) {
        this.vocType = vocType;
    }

    public String getExitVocCode() {
        return exitVocCode;
    }

    public void setExitVocCode(String exitVocCode) {
        this.exitVocCode = exitVocCode;
    }

    public String getExitVocNum() {
        return exitVocNum;
    }

    public void setExitVocNum(String exitVocNum) {
        this.exitVocNum = exitVocNum;
    }

    public String getVoiNum() {
        return voiNum;
    }

    public void setVoiNum(String voiNum) {
        this.voiNum = voiNum;
    }

    public String getVocState() {
        return vocState;
    }

    public void setVocState(String vocState) {
        this.vocState = vocState;
    }

    public String getTradInf1() {
        return tradInf1;
    }

    public void setTradInf1(String tradInf1) {
        this.tradInf1 = tradInf1;
    }

    public String getTradInf2() {
        return tradInf2;
    }

    public void setTradInf2(String tradInf2) {
        this.tradInf2 = tradInf2;
    }

    public String getTradInf3() {
        return tradInf3;
    }

    public void setTradInf3(String tradInf3) {
        this.tradInf3 = tradInf3;
    }

    public String getTradInf4() {
        return tradInf4;
    }

    public void setTradInf4(String tradInf4) {
        this.tradInf4 = tradInf4;
    }

    public String getTradInf5() {
        return tradInf5;
    }

    public void setTradInf5(String tradInf5) {
        this.tradInf5 = tradInf5;
    }

    public String getTradInf6() {
        return tradInf6;
    }

    public void setTradInf6(String tradInf6) {
        this.tradInf6 = tradInf6;
    }

    public String getTradInf7() {
        return tradInf7;
    }

    public void setTradInf7(String tradInf7) {
        this.tradInf7 = tradInf7;
    }

    public String getTradInf8() {
        return tradInf8;
    }

    public void setTradInf8(String tradInf8) {
        this.tradInf8 = tradInf8;
    }
}
