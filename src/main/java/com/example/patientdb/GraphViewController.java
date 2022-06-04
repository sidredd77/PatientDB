package com.example.patientdb;

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
    private BarChart chart;
    @FXML
    private Button back;
    public void setGraph(ArrayList<Patient> PatientList){

        XYChart.Series series1 = new XYChart.Series();


        for(int i = 0; i<PatientList.size(); i++){
            series1.setName(PatientList.get(i).getFirstName() + PatientList.get(i).getLastName());
            series1.getData().add(new XYChart.Data(PatientList.get(i).getLastName(), PatientList.get(i).getAge()));

        }
        chart.getData().addAll(series1);

    }
    public void doneClickedON() throws IOException {
        PatientDBApp.SwitchListView();
    }
}
