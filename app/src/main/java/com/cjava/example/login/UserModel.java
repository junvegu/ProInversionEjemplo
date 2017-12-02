package com.cjava.example.login;

/**
 * Created by junior on 01/12/17.
 */

public class UserModel {




    private String email;
    private String first_name;
    private String last_name;
    private String picture;


    public UserModel(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
