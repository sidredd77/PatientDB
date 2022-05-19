package com.example.patientdb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsViewController {
    @FXML
    private Button Done;
    @FXML
    public void DoneClickedOn() throws IOException {
            try {
                FileOutputStream fileOut = new FileOutputStream("settings.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(Settings.getInstance());
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in settings.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }

            PatientDBApp.SwitchListView();
        }
    }

