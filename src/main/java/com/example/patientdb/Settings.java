package com.example.patientdb;

import java.io.Serializable;

public class Settings implements Serializable {
    private int fontSize;
    private static Settings instance;
    public Settings() {
    }
    public int getFSize(){
       return instance.getFSize();
    }
}
