package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientDBApp extends Application {
    private static Stage stage1;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PatientDBApp.class.getResource("PatientListView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Patient");
        stage.setScene(scene);
        stage.show();
        this.stage1 = stage;
    }

    public void SwitchPatientView(Patient p){
        FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("PatientView.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        PatientViewController patientController = loader.getController();
        // Your code here: pass the patient to the patientController...
        this.stage1.setScene(myScene); // the initialize method will get called in here

    }

    public static void main(String[] args) {
        launch();
    }
}