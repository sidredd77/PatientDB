package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PatientDBApp extends Application {
    private static Stage stage1;
    private static Scene PatientScene;
    private static Scene ListScene;

    private static PatientListController patientListController;

    private static PatientViewController patientViewController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("PatientListView.fxml"));
        stage1 = stage;
        Parent root = loader.load();
        ListScene = new Scene(root);
        patientListController = loader.getController();
        patientListController.restart();
        // Your code here: pass the patient to the patientController...
        stage1.setScene(ListScene); // the initialize method will get called in here
        stage1.show();

    }
    public static void SwitchListView() throws IOException{


        stage1.setScene(ListScene);
        patientListController.restart();
        patientListController.serialize();


    }

    public  static void SwitchPatientView(Patient p) throws IOException{
        if (PatientScene == null) {
            FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("PatientView.fxml"));
            Parent root = loader.load();
            PatientScene = new Scene(root);
            patientViewController = loader.getController();

            // Your code here: pass the patient to the patientController...
            stage1.setScene(PatientScene); // the initialize method will get called in here
            patientViewController.setPatient(p);
        }
        else{

            stage1.setScene(PatientScene);
            patientViewController.setPatient(p);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}