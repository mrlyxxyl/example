package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateAction extends ActionSupport {

    private String username;
    private String mobile;
//    private String birthday;

    public String save() {
        ActionContext.getContext().put("message", "����ɹ���");
        return "success";
    }

    public String update() {
        ActionContext.getContext().put("message", "���³ɹ���");
        return "success";
    }

   /* *//**
     * У��Save����
     *//*
    public void validateSave() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "�û�������Ϊ�գ�");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "�ֻ��Ų���Ϊ�գ�");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "�ֻ��Ÿ�ʽ���ԣ�");
        }
//        try {
//            format.parse(birthday);
//        } catch (ParseException e) {
//            this.addFieldError("birthday", "���ڸ�ʽΪ��yyyyMMdd��");
//        }
        super.validate();
    }*/

    /**
     * У��Update����
     *//*
    public void validateUpdate() {
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "�û�������Ϊ�գ�");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "�ֻ��Ų���Ϊ�գ�");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "�ֻ��Ÿ�ʽ���ԣ�");
        }
        try {
            format.parse(birthday);
        } catch (ParseException e) {
            this.addFieldError("birthday","���ڸ�ʽΪ��yyyyMMdd��");
        }
        super.validate();
    }*/

    /**
     * �������з���
     *//*
    @Override
    public void validate() {
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "�û�������Ϊ�գ�");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "�ֻ��Ų���Ϊ�գ�");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "�ֻ��Ÿ�ʽ���ԣ�");
        }

        try {
            format.parse(birthday);
        } catch (ParseException e) {
            this.addFieldError("birthday","���ڸ�ʽΪ��yyyyMMdd��");
        }
        super.validate();
    }*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
}
