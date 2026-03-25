import java.util.Scanner;

public class DoctorChannalSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== Doctor Channal System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Receptionist");
            System.out.println("3. Patient Login");
            System.out.println("4. Receptionist Login");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    PatientRegistrationPage.register(scanner);
                    break;

                case "2":
                    ReceptionistRegisterPage.register(scanner);
                    break;

                case "3":
                    Patient patient = LoginService.patientLogin(scanner);
                    if (patient != null) {
                        new PatientDashboard(scanner).start(patient);
                    }
                    break;

                case "4":
                    Receptionist receptionist = LoginService.receptionistLogin(scanner);
                    if (receptionist != null) {
                        new ReceptionistDashboard(scanner).start(receptionist);
                    }
                    break;

                case "0":
                    System.out.println("Doctor Channal System exited successfully.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
