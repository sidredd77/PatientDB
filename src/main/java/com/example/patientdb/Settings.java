package com.example.patientdb;

import java.io.Serializable;

public class Settings implements Serializable {
    private int fontSize;
    private static Settings instance;
    private Settings() {
    }
    public static int getFSize(){
       return instance.getFSize();
    }
}
