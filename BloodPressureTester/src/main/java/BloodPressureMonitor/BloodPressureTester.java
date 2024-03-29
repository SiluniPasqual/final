/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package BloodPressureMonitor;

/**
 *
 * @author siluni
 */

import java.util.ArrayList;
import java.util.Scanner;

//BloodPressureTester class allows users to interactively manage blood pressure records.
public class BloodPressureTester {

    //Main method to run the BloodPressureTester program.
    public static void main(String[] args) {
        ArrayList<BloodPressureRecord> records = new ArrayList<>();
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        //Main loop for user interaction
        while (running) {
            displayMenu();
            int input = scanner.nextInt();

            switch (input) {
                case 0 -> running = exitProgram();
                case 1 -> createRecord(records);
                case 2 -> {
                    System.out.println("\nBlood Pressure Records...");
                    displayRecords(records);
                }
                case 3 -> {
                    System.out.println("\nEnter the record number: ");
                    int recordNum = scanner.nextInt();
                    System.out.println("Record " + recordNum + " Details");
                    viewRecordDetails(records, recordNum);
                }
                case 4 -> clearRecords(records);
                default -> System.out.println("\nInvalid option! Please select a valid option.");
            }
            System.out.println();
        }
    }

    //Display the main menu options
    public static void displayMenu() {
        System.out.println("\nMenu...");
        System.out.println("1. Create a Record");
        System.out.println("2. Show all users");
        System.out.println("3. Select a user");
        System.out.println("4. Delete all");
        System.out.println("0. Exit");
    }

    //Exits the program
    public static boolean exitProgram() {
        return false;
    }

    /**
     * Creates a new blood pressure record.
     * @param recordList List of blood pressure records.
     */
    public static void createRecord(ArrayList<BloodPressureRecord> recordList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nHow many users do you want to create?");
        int create = scanner.nextInt();

        //Loop to create new records
        for (int i = 0; i < create; i++) {
            System.out.println("\nEnter User ID: ");
            int id = scanner.nextInt();

            System.out.println("Enter User Name: ");
            String user_name = scanner.next();

            System.out.println("Enter User's Year of Birth:");
            int birthYear = scanner.nextInt();

            System.out.println("Enter User Systolic blood pressure: ");
            int systolic = scanner.nextInt();

            System.out.println("Enter User Diastolic blood pressure: ");
            int diastolic = scanner.nextInt();

            // Get blood pressure category
            String category = getBloodPressureCategory(systolic, diastolic);

            recordList.add(new BloodPressureRecord(id, user_name, birthYear, systolic, diastolic, category));
        }
    }

    /**
     * Displays all blood pressure records.
     * @param recordList List of blood pressure records.
     */
    public static void displayRecords(ArrayList<BloodPressureRecord> recordList) {
        for (BloodPressureRecord record : recordList) {
            record.display();
        }
    }

    /**
     * Displays details of a specific blood pressure record.
     * @param recordList List of blood pressure records.
     * @param recordNumber Record number to display details.
     */
    public static void viewRecordDetails(ArrayList<BloodPressureRecord> recordList, int recordNumber) {
        if (recordNumber >= 1 && recordNumber <= recordList.size()) {
            recordList.get(recordNumber - 1).display();
        } else {
            System.out.println("\nInvalid record number.");
        }
    }

    //Clears all blood pressure records
    public static void clearRecords(ArrayList<BloodPressureRecord> recordList) {
        recordList.clear();
        System.out.println("\nAll records deleted.");
    }

     /**
     * Determines the blood pressure category based on systolic and diastolic values.
     * @param systolic Systolic blood pressure value.
     * @param diastolic Diastolic blood pressure value.
     * @return Blood pressure category.
     */
    public static String getBloodPressureCategory(int systolic, int diastolic) {
        if (systolic < 90 && diastolic < 60) {
            return "Low";
        } else if ((systolic >= 90 && systolic <= 120) && (diastolic >= 60 && diastolic <= 80)) {
            return "Normal";
        } else if ((systolic > 120 && systolic <= 140) || (diastolic > 80 && diastolic <= 90)) {
            return "Prehypertension";
        } else if ((systolic > 140 && systolic <= 160) || (diastolic > 90 && diastolic <= 100)) {
            return "High: Stage 1 Hypertension";
        } else if (systolic > 160 || diastolic > 100) {
            return "High: Stage 2 Hypertension";
        } else {
            return "Unknown";
        }
    }
}











