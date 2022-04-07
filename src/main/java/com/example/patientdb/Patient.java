package com.example.patientdb;

import java.util.Date;

public class Patient {
    private String firstName, lastName;
    private int age;
    private int whiteCellCount;
    private Date createdTime;

    public Patient(String fn, String ln, int a, int whiteCell){
        createdTime = new Date();
        firstName = fn;
        lastName = ln;
        age = a;
        whiteCellCount = whiteCell;
    }

    public int getWhiteCellCount(){
        return whiteCellCount;
    }

    public int getAge(){
        return age;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void getOlder(){
        age++;
    }

    public Date getCreation() {
        return createdTime;
    }

    public String toString(){
        return lastName+", "+firstName+" ("+age+"): WBCC: "+whiteCellCount;
    }
}
