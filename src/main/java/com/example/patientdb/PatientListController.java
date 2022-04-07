package com.example.patientdb;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;
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
}