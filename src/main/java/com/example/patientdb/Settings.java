package com.example.patientdb;

import java.io.*;
import java.util.ArrayList;

public class Settings implements Serializable {
    private int fontSize;
    private static Settings instance;
    private Settings() {
    }
    public static int getFSize(){

        if (Settings.instance == null) {
            try {
                FileInputStream fileIn = new FileInputStream(System.getProperty("\"settings.ser\"");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                instance= (Settings )in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                Settings.instance = new Settings();

            } catch (ClassNotFoundException c) {
                System.out.println("not found");
                c.printStackTrace();


        }
        return instance.getFSize();
    }
    public static Settings getInstance(){
        return instance;
    }
    public static void setFSize(int fontSize1){

        if (Settings.instance == null) {
            Settings.instance = new Settings();
        }
        instance.setFSize(fontSize1);
    }


}
