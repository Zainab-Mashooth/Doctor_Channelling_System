import java.util.Scanner;

public class ReceptionistDashboard {

    private final Scanner scanner;

    public ReceptionistDashboard(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(Receptionist receptionist) {

        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n=== Receptionist Dashboard ===");
            System.out.println("1. View My Details");
            System.out.println("2. View All Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. View All Appointments");
            System.out.println("6. Logout");
            System.out.println("7. View Waiting Queue");
            System.out.println("8. Sort Patients by Age");
            System.out.print("Select option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewDetails(receptionist);
                    break;

                case "2":
                    viewPatients();
                    break;

                case "3":
                    AddDoctorPage.addDoctor(scanner);
                    break;

                case "4":
                    DataStore.displayDoctors();
                    break;

                case "5":
                    DataStore.displayAppointments();
                    break;

                case "6":
                    System.out.println("Logged out successfully.");
                    loggedIn = false;
                    break;

                case "7":
                    WaitingQueue.displayQueue();
                    break;

                case "8":
                    SortPatientsByAgePage.sortAndDisplay();
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewDetails(Receptionist receptionist) {
        System.out.println("\n--- Receptionist Details ---");
        System.out.println("ID   : " + receptionist.getId());
        System.out.println("Name : " + receptionist.getName());
    }

    private void viewPatients() {
        System.out.println("\n--- Patient List ---");
        DataStore.displayAllPatients();
    }
}
