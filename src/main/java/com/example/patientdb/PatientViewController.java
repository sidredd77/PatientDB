package com.example.patientdb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PatientViewController {
    @FXML
    private Button Done;
    @FXML
    private TextField First;
    @FXML
    private TextField Last;
    @FXML
    private TextField Age;
    private Patient patient;
    @FXML
    public void DoneClickedOn() throws IOException {
        patient.setLastName(Last.getText());
        patient.setFirstName(First.getText());
        String ageStr = this.Age.getText();
        patient.setAge(Integer.parseInt(ageStr));
        PatientDBApp.SwitchListView();

    }
   public void setPatient(Patient p){
        this.patient = p;
        First.setText(p.getFirstName());
        Last.setText(p.getLastName());
        Age.setText(Integer.toString(p.getAge()));
    }


}
