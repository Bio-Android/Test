package com.example.test.models;

import android.util.Patterns;

import java.io.Serializable;

public class LoginModel implements Serializable {



    private String strName;
    private int id;


    public String getStrName() {
        return strName;
    }

    public int getId() {
        return id;
    }

    public LoginModel(String strName, int id) {
        this.strName = strName;
        this.id = id;
    }


}