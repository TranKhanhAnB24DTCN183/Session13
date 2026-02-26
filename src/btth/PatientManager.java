package btth;

import java.util.ArrayList;

public class PatientManager {
    ArrayList<Patient> listPatient = new ArrayList<>();

    public void addPatient(Patient patient) {
        listPatient.add(patient);
    }

    public void removePatient(String ID) {
        for (Patient patient : listPatient) {
            if (patient.getID().equals(ID)) {
                listPatient.remove(patient);
                break;
            }
        }
    }

    public void updatePatient(String ID, Patient newPatient) {
        for (int i = 0; i < listPatient.size(); i++) {
            if (listPatient.get(i).getID().equals(ID)) {
                listPatient.set(i, newPatient);
                break;
            }
        }
    }

    public void searchPatient(String name) {
        for (Patient patient : listPatient) {
            if (patient.getName().equals(name)) {
                System.out.println("ID: " + patient.getID());
                System.out.println("Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Sex: " + patient.getSex());
                System.out.println("Sickduck: " + patient.getSickduck());
                return;
            }
        }
    }

    public void displayPatients() {
        for (Patient patient : listPatient) {
            System.out.println("ID: " + patient.getID());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Sex: " + patient.getSex());
            System.out.println("Sickduck: " + patient.getSickduck());
            System.out.println("================================");
        }
    }
}
