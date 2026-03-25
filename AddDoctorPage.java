import java.util.Scanner;

public class AddDoctorPage {

    public static void addDoctor(Scanner scanner) {

        System.out.println("\n--- Add Doctor ---");

        System.out.print("Enter Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization);
        DataStore.addDoctor(doctor);

        System.out.println("Doctor added successfully.");
    }
}
