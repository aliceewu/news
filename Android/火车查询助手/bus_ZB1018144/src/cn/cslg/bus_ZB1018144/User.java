package cn.cslg.bus_ZB1018144;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private int id;
    private String username;
    private String password;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
