package com.cjava.example.login;

import java.io.Serializable;

/**
 * Created by junior on 01/12/17.
 */

public class UserModel implements Serializable{




    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private PictureModel picture;
    private String gender;





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

    public PictureModel getPicture() {
        return picture;
    }

    public void setPicture(PictureModel picture) {
        this.picture = picture;
    }
}
