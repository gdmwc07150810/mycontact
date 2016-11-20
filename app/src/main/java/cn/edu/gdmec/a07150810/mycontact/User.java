package cn.edu.gdmec.a07150810.mycontact;

/**
 * Created by qaq on 2016/11/15.
 */
public class User {

    public static final String NAME = "name";
    public static final String MOBILE = "mobile";
    public static final String QQ ="qq" ;
    public static final String DANWEI ="danwei" ;
    public static final String ADDRESS = "address";
    private String name;
    private String address;
    private String mobile;
    private String danwei;
    private String qq;
    private int id_DB=-1;

    public void setName(String name) {
        this.name=name;
    }

    public void setMobile(String mobile) {
        this.mobile=mobile;
    }

    public void setDanwei(String s) {
        this.danwei=danwei;
    }

    public void setQq(String s) {
        this.qq=qq;
    }

    public void setAddress(String s) {
        this.address=address;
    }
    public void setId_DB(int id_db) {
        this.id_DB=id_DB;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDanwei() {
        return danwei;
    }

    public String getQq() {
        return qq;
    }

    public int getId_DB() {return id_DB;}
}
