package com.example.android_final_project;

public class Salesperson {
    private String spFullname ;
    private String spUsername ;
    private String spPassword ;
    private String spPhone ;
    private String spEmail ;

    public Salesperson(String spFullname, String spUsername, String spPassword, String spPhone, String spEmail) {
        this.spFullname = spFullname;
        this.spUsername = spUsername;
        this.spPassword = spPassword;
        this.spPhone = spPhone;
        this.spEmail = spEmail;
    }

    public String getSpFullname() {
        return spFullname;
    }

    public void setSpFullname(String spFullname) {
        this.spFullname = spFullname;
    }

    public String getSpUsername() {
        return spUsername;
    }

    public void setSpUsername(String spUsername) {
        this.spUsername = spUsername;
    }

    public String getSpPassword() {
        return spPassword;
    }

    public void setSpPassword(String spPassword) {
        this.spPassword = spPassword;
    }

    public String getSpPhone() {
        return spPhone;
    }

    public void setSpPhone(String spPhone) {
        this.spPhone = spPhone;
    }

    public String getSpEmail() {
        return spEmail;
    }

    public void setSpEmail(String spEmail) {
        this.spEmail = spEmail;
    }
}
