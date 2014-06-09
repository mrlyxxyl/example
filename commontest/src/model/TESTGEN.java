package model;
import java.util.Date;

public class TESTGEN {

    private String tchar;
    private int tint;
    private double tdouble;
    private String tvarchar;
    private Date tdate;

    public void setTchar(String tchar) {
        this.tchar = tchar;
    }
    public String getTchar() {
        return tchar;
    }

    public void setTint(int tint) {
        this.tint = tint;
    }
    public int getTint() {
        return tint;
    }
    public void setTdouble(double tdouble) {
        this.tdouble = tdouble;
    }

    public double getTdouble() {
        return tdouble;
    }

    public void setTvarchar(String tvarchar) {
        this.tvarchar = tvarchar;
    }
    public String getTvarchar() {
        return tvarchar;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public Date getTdate() {
        return tdate;
    }

}