import java.util.Scanner;

public class PatientRegistrationPage {

    public static void register(Scanner scanner) {

        System.out.println("\n--- Patient Registration ---");

        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();

        if (DataStore.getPatientById(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        Patient patient = new Patient(id, name, password, age);
        DataStore.addPatient(patient);

        System.out.println("Patient registered successfully.");
    }
}
