import java.util.Scanner;

public class CancelAppointmentPage {

    public static void cancel(Patient patient, Scanner scanner) {

        if (patient.getAppointments().isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }

        System.out.println("\n--- Cancel Appointment ---");
        for (Appointment a : patient.getAppointments()) {
            System.out.println(a.getAppointmentId() + " | " + a.getDoctor().getName());
        }

        System.out.print("Enter Appointment ID to cancel: ");
        String id = scanner.nextLine();

        Appointment toRemove = null;

        for (Appointment a : patient.getAppointments()) {
            if (a.getAppointmentId().equals(id)) {
                toRemove = a;
                break;
            }
        }

        if (toRemove != null) {
            patient.removeAppointment(toRemove);
            DataStore.removeAppointment(toRemove);
            WaitingQueue.addPatient(patient); // move to waiting list
            System.out.println("Appointment cancelled. Added to waiting queue.");
        } else {
            System.out.println("Appointment not found.");
        }
    }
}
