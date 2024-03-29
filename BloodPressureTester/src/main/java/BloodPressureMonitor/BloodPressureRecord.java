/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BloodPressureMonitor;

/**
 *
 * @author siluni
 */

//BloodPressureRecord class represents a single blood pressure record for a patient.
public class BloodPressureRecord {
    //Instant variables
    private final int id;                   //Record ID
    private final String name;              //User name
    private final int yob;                  //Year of Birth
    private final int systolic;             //Systolic Blood Pressure
    private final int diastolic;            //Diastolic Blood Pressure
    private final String category;          //Blood Pressure Category

    //Constructor to initialize a BloodPressureRecord object.
    public BloodPressureRecord(int id, String name, int yob, int systolic, int diastolic, String category) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.category = category;
    }

    //Method to display the blood pressure record details.
    public void display() {
        System.out.println("Record ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Birth Year: " + yob);
        System.out.println("Blood Pressure: " + systolic + "/" + diastolic);
        System.out.println("Category: " + category);
        System.out.println("");
    }
}





