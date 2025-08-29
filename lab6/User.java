package com.example.lab3;

import android.widget.EditText;

public class User {
    String nameUser;
    String idUser;

    public User(String nameUser) {
        this.nameUser = nameUser;
    }

    public User(EditText nameUser) {
    }

    //getter
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
