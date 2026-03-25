import java.util.Scanner;

public class PatientDashboard {

    private final Scanner scanner;

    public PatientDashboard(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(Patient patient) {

        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n=== Patient Dashboard ===");
            System.out.println("1. View My Details");
            System.out.println("2. Book Appointment");
            System.out.println("3. View My Appointments");
            System.out.println("4. Request Home Visit");
            System.out.println("5. Logout");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Reschedule Appointment");
            System.out.print("Select option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewDetails(patient);
                    break;

                case "2":
                    BookAppointmentPage.book(patient, scanner);
                    break;

                case "3":
                    viewAppointments(patient);
                    break;

                case "4":
                    HomeVisitRequestPage.request(patient, scanner);
                    break;

                case "5":
                    System.out.println("Logged out successfully.");
                    loggedIn = false;
                    break;

                case "6":
                    CancelAppointmentPage.cancel(patient, scanner);
                    break;

                case "7":
                    RescheduleAppointmentPage.reschedule(patient, scanner);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewDetails(Patient patient) {
        System.out.println("\n--- My Details ---");
        System.out.println("ID   : " + patient.getId());
        System.out.println("Name : " + patient.getName());
        System.out.println("Age  : " + patient.getAge());
    }

    private void viewAppointments(Patient patient) {
        System.out.println("\n--- My Appointments ---");

        if (patient.getAppointments().isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : patient.getAppointments()) {
            System.out.println(
                a.getAppointmentId() + " | Doctor: " +
                a.getDoctor().getName() + " (" +
                a.getDoctor().getSpecialization() + ")"
            );
        }
    }
}
