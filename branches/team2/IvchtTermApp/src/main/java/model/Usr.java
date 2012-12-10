package model;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 10.12.12
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class Usr {
    private int user_id;
    private String user_login;
    private String user_password;
    private String user_hash;
    private String user_ip;
    private int prava;

    public Usr(){

    }

    public Usr(int user_id, String user_login,String user_password, int prava){
        this.user_id=user_id;
        this.user_login=user_login;
        this.user_password=user_password;
        this.prava=prava;
    }

    public Usr(String user_name, String user_pass) {
        this.user_login=user_login;
        this.user_password=user_password; //To change body of created methods use File | Settings | File Templates.
    }

    public Usr(int user_id, String user_login, String user_password, String user_hash, String user_ip, int prava) {
        this.user_id=user_id;
        this.user_login=user_login;
        this.user_password=user_password;
        this.prava=prava;
        this.user_hash=user_hash;
        this.user_ip=user_ip;
        this.prava=prava;
        //To change body of created methods use File | Settings | File Templates.
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getUser_name() {
        return user_login;
    }

    public void setUser_name(String user_name) {
        this.user_login = user_login;
    }

    public String getUser_hash() {
        return user_hash;
    }

    public void setUser_hash(String user_hash) {
        this.user_hash = user_hash;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public int getPrava() {
        return prava;
    }

    public void setPrava(int prava) {
        this.prava = prava;
    }

    public String getUser_pass() {
        return user_password;
    }

    public void setUser_pass(String user_pass) {
        this.user_password = user_password;
    }
}
