package com.example.patientdb;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

public class GraphViewController {
    @FXML
    private BarChart<String, Number> chart;
    @FXML
    private Button back;
    public void setGraph(ArrayList<Patient> PatientList){

        XYChart.Series series1 = new XYChart.Series();;
        series1.setName("Age");
        for(int i = 0; i<PatientList.size(); i++){

            series1.getData().add(new XYChart.Data(PatientList.get(i).getLastName(), PatientList.get(i).getAge()));

        }

        chart.getData().add(series1);


    }
    public void doneClickedON() throws IOException {
        PatientDBApp.SwitchListView();
    }
}
