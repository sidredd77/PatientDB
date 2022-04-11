package com.example.patientdb;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        patientList.add(new Patient("Alison", "Apple", 49, 5000));
        patientList.add(new Patient("Bill", "Baker", 18, 1001));
        patientList.add(new Patient("Curt", "Cartwright", 37, 10500));
        patientList.add(new Patient("Dilan", "Dolan", 76, 789));

        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        WBCColumn.setCellValueFactory(new PropertyValueFactory<>("whiteCellCount"));
        table.setItems(FXCollections.observableList(patientList));
    }
    public void buttonPress(){

        List PatientList = table.getItems();

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
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your last name");
        Optional<String> result2 = dialog.showAndWait();
        if (result2.isPresent()){
            lastName = result2.get();

        }
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your White Blood Cell Count");
        Optional<String> result3 = dialog.showAndWait();
        if (result3.isPresent()){
            try(){
                WBC = parseInt(result3.get());
            }
            catch(NumberFormatException){
                System.out.println("stop");
            }

        }
        dialog = new TextInputDialog("");
        dialog.setContentText("What is your age");
        Optional<String> result4 = dialog.showAndWait();
        if (result4.isPresent()){
            age = parseInt(result4.get());

        }
        PatientList.add(new Patient(firstName, lastName, age, WBC));
    }
}