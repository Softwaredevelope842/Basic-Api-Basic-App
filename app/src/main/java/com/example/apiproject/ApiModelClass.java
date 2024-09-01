package com.example.apiproject;

import android.icu.text.CaseMap;

import org.intellij.lang.annotations.JdkConstants;

public class ApiModelClass {
    public static int userId;
    public static int id;
    public static String title;
    public static String body;

    public ApiModelClass(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public ApiModelClass() {
    }

    public static String getTittle() {
        return title;
    }


    public static int getUserId() {
            return userId;
        }

        public void setUserId ( int userId){
            this.userId = userId;
        }

        public static int getId() {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public static String getBody() {
            return body;
        }

        public void setBody (String body){
            this.body = body;
        }

}

