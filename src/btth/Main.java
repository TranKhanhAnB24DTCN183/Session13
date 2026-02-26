package btth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager patientManager = new PatientManager();

        Patient patient1 = new Patient("001", "An An", 30, "Nam", "Sot");
        patientManager.addPatient(patient1);
        Patient patient2 = new Patient("002", "Nhi Nhi", 25, "Nu", "Dau dau");
        patientManager.addPatient(patient2);
        int check = 0;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            check = sc.nextInt();
            sc.nextLine();
            switch (check){
                case 1:
                    System.out.print("Enter ID: ");
                    String ID = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Sex: ");
                    String sex = sc.nextLine();
                    System.out.print("Enter Sickduck: ");
                    String sickduck = sc.nextLine();
                    Patient newPatient = new Patient(ID, name, age, sex, sickduck);
                    patientManager.addPatient(newPatient);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String removeID = sc.nextLine();
                    patientManager.removePatient(removeID);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String updateID = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int updateAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Sex: ");
                    String updateSex = sc.nextLine();
                    System.out.print("Enter Sickduck: ");
                    String updateSickduck = sc.nextLine();
                    Patient updatePatient = new Patient(updateID, updateName, updateAge, updateSex, updateSickduck);
                    patientManager.updatePatient(updateID, updatePatient);
                    break;
                case 4:
                    System.out.print("Enter Name: ");
                    String searchName = sc.nextLine();
                    patientManager.searchPatient(searchName);
                    break;
                case 5:
                    patientManager.displayPatients();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (check != 6);

    }

    public static void displayMenu() {
        System.out.println("1. Add patient");
        System.out.println("2. Remove patient");
        System.out.println("3. Update patient");
        System.out.println("4. Search patient");
        System.out.println("5. Display all patients");
        System.out.println("6. Exit");
    }
}
