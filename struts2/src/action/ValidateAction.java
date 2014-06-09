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
        ActionContext.getContext().put("message", "保存成功！");
        return "success";
    }

    public String update() {
        ActionContext.getContext().put("message", "更新成功！");
        return "success";
    }

   /* *//**
     * 校验Save（）
     *//*
    public void validateSave() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "用户名不能为空！");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "手机号不能为空！");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "手机号格式不对！");
        }
//        try {
//            format.parse(birthday);
//        } catch (ParseException e) {
//            this.addFieldError("birthday", "日期格式为：yyyyMMdd！");
//        }
        super.validate();
    }*/

    /**
     * 校验Update（）
     *//*
    public void validateUpdate() {
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "用户名不能为空！");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "手机号不能为空！");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "手机号格式不对！");
        }
        try {
            format.parse(birthday);
        } catch (ParseException e) {
            this.addFieldError("birthday","日期格式为：yyyyMMdd！");
        }
        super.validate();
    }*/

    /**
     * 检验所有方法
     *//*
    @Override
    public void validate() {
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "用户名不能为空！");
        }
        if (mobile == null || "".equals(mobile.trim())) {
            this.addFieldError("mobile", "手机号不能为空！");
        } else if (!mobile.matches("1[358]\\d{9}")) {
            this.addFieldError("mobile", "手机号格式不对！");
        }

        try {
            format.parse(birthday);
        } catch (ParseException e) {
            this.addFieldError("birthday","日期格式为：yyyyMMdd！");
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
