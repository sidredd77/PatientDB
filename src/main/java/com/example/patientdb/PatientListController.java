package com.example.patientdb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

public class PatientListController {


    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn ageColumn;
    @FXML
    private TableView table;
    @FXML
    private TableColumn WBCColumn;
    @FXML
    private Button BtnNew;

    public void initialize() {
        List patientList = new ArrayList();


        try {
            FileInputStream fileIn = new FileInputStream(System.getProperty("user.home")+"/.patientDB"+ "/.PatientDB.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            patientList= (ArrayList<Patient>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("not found");
            c.printStackTrace();

        }
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        WBCColumn.setCellValueFactory(new PropertyValueFactory<>("whiteCellCount"));
        table.setItems(FXCollections.observableList(patientList));
    }
    public void buttonPress(){

        ObservableList PatientList = table.getItems();

        String firstName ="";
        String lastName ="";
        int age = 0;
        int WBC = 0;
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your First name:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()){
            firstName = result.get();

        }
        else {
            return;
        }
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your last name");
        Optional<String> result2 = dialog.showAndWait();
        if (result2.isPresent()){
            lastName = result2.get();

        }
        else {
            return;
        }
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your White Blood Cell Count");
        Optional<String> result3 = dialog.showAndWait();
        if (result3.isPresent()){
            try{
                WBC = parseInt(result3.get());
            }
            catch(NumberFormatException n){
                System.out.println("Don't do that");
            }


        }
        else {
            return;
        }
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your age");
        Optional<String> result4 = dialog.showAndWait();
        if (result4.isPresent()){
            try{
                age = parseInt(result4.get());
            }
            catch(NumberFormatException n){
                System.out.println("Don't do that");
            }

        }
        else {
            return;
        }


        Patient e = new Patient(firstName, lastName, age, WBC);
        PatientList.add(e);
        public  void serialize(){
            try {
                if (!Files.exists(Paths.get(System.getProperty("user.home") + "/.patientDB"))) {
                    Files.createDirectory(Paths.get(System.getProperty("user.home") + "/.patientDB"));
                }

                ArrayList<Patient> change = new ArrayList(PatientList);
                FileOutputStream fileOut =
                        new FileOutputStream(System.getProperty("user.home") + "/.patientDB" + "/.PatientDB.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(change);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in PatientDB.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }

    }
    @FXML
    public void ClickedOn() throws IOException {
        Patient p = (Patient) table.getSelectionModel().getSelectedItem();
        PatientDBApp.SwitchPatientView(p);
   }
   public void restart(){
        table.refresh();


    }
}