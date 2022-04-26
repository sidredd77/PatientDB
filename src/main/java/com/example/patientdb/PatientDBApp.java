package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientDBApp extends Application {
    private static Stage stage1;
    private static Scene PatientScene;
    private static Scene ListScene;

    private static PatientListController patientController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("PatientListView.fxml"));
        stage1 = stage;
        Parent root = loader.load();
        ListScene = new Scene(root);
        patientController = loader.getController();
        patientController.restart();
        // Your code here: pass the patient to the patientController...
        stage1.setScene(ListScene); // the initialize method will get called in here
        stage1.show();

    }
    public static void SwitchListView() throws IOException{


        stage1.setScene(ListScene);
        patientController.restart();




    }

    public  static void SwitchPatientView(Patient p) throws IOException{
        if (PatientScene == null) {
            FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("PatientView.fxml"));
            Parent root = loader.load();
            PatientScene = new Scene(root);
            PatientViewController patientController = loader.getController();
            patientController.setPatient(p);
            // Your code here: pass the patient to the patientController...
            stage1.setScene(PatientScene); // the initialize method will get called in here
        }
        else{
            stage1.setScene(PatientScene);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}