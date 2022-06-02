package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PatientDBApp extends Application {
    private static Stage stage1;
    private static Scene PatientScene;
    private static Scene ListScene;

    private static PatientListController patientListController;

    private static PatientViewController patientViewController;

    private static SettingsViewController settingsController;
    private static Scene SettingsScene;
    private static Scene GraphScene;
    private static GraphViewController graphController;

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
        patientListController.settingsRestart();
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
    public  static void SwitchSettingsView() throws IOException{
        if (SettingsScene == null) {
            FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("SettingsView.fxml"));
            Parent root = loader.load();
            SettingsScene = new Scene(root);
            settingsController = loader.getController();

            // Your code here: pass the patient to the patientController...
            stage1.setScene(SettingsScene); // the initialize method will get called in here
            settingsController.setSettings();

        }
        else{

            stage1.setScene(SettingsScene);

        }
    }
    public  static void SwitchGraphView(ArrayList<Patient> PatientList) throws IOException{
        if (GraphScene == null) {
            FXMLLoader loader = new FXMLLoader(PatientDBApp.class.getResource("GraphView.fxml"));
            Parent root = loader.load();
            GraphScene = new Scene(root);
            graphController = loader.getController();

            // Your code here: pass the patient to the patientController...
            stage1.setScene(GraphScene); // the initialize method will get called in here
            GraphViewController.graph(PatientList);


        }
        else{

            stage1.setScene(GraphScene);

        }
    }



    public static void main(String[] args) {
        launch();
    }
}