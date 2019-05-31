package com.example.realm.Teacher;

import android.app.Application;
import android.database.Cursor;

import io.realm.RealmObject;

public class Teddy extends RealmObject {
    private String Username;
    private int Password;



    public Teddy() {
    }

    public Teddy(String Username, int Password ) {
        this.Username = Username;
        this.Password = Password;

    }

    public String getUsername(String trim) {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getPassword(int trim) {
        return Password;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }


    @Override
    public String toString() {
        return "Teddy{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +

                '}';
    }

}