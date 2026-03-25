import java.util.Scanner;

public class LoginService {

    public static Patient patientLogin(Scanner scanner) {

        System.out.println("\n--- Patient Login ---");
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Patient patient = DataStore.getPatientById(id);

        if (patient != null && patient.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome " + patient.getName());
            return patient;
        }

        System.out.println("Invalid Patient ID or Password.");
        return null;
    }

    public static Receptionist receptionistLogin(Scanner scanner) {

        System.out.println("\n--- Receptionist Login ---");
        System.out.print("Enter Receptionist ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Receptionist receptionist = DataStore.getReceptionistById(id);

        if (receptionist != null && receptionist.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome " + receptionist.getName());
            return receptionist;
        }

        System.out.println("Invalid Receptionist ID or Password.");
        return null;
    }
}
