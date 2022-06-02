package com.example.patientdb;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class GraphViewController {
    public static BarChart<String,Number> graph(ArrayList<Patient> PatientList){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Age Graph");
        xAxis.setLabel("Patients");
        yAxis.setLabel("values");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Ages");
        for(int i = 0; i<PatientList.size(); i++){
            series1.getData().add(new XYChart.Data(PatientList.get(i).getLastName(), PatientList.get(i).getAge()));
        }
        bc.getData().addAll(series1);
        return bc;
    }
}
