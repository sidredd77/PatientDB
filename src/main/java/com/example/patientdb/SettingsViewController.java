package com.example.patientdb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsViewController {
    @FXML
    private Button Done;
    @FXML
    private TextField settingsType;


    @FXML
    public void DoneClickedOn() throws IOException {
        if (this.settingsType != null) {
            String ageStr = this.settingsType.getText();
            Settings.setFSize(Integer.parseInt(ageStr));
            try {
                FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + "/.patientDB" + "/.Settings.ser");
                ;
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(Settings.getInstance());
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in settings.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }



        }
        PatientDBApp.SwitchListView();
    }
        public void setSettings(){

            settingsType.setText(Integer.toString(Settings.getFSize()));

        }

    }

