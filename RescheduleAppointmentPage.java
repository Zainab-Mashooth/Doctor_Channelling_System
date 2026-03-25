import java.util.Scanner;

public class RescheduleAppointmentPage {

    public static void reschedule(Patient patient, Scanner scanner) {

        if (patient.getAppointments().isEmpty()) {
            System.out.println("No appointments to reschedule.");
            return;
        }

        System.out.println("\n--- Reschedule Appointment ---");
        for (Appointment a : patient.getAppointments()) {
            System.out.println(a.getAppointmentId() + " | " + a.getDoctor().getName());
        }

        System.out.print("Enter Appointment ID: ");
        String id = scanner.nextLine();

        Appointment old = null;
        for (Appointment a : patient.getAppointments()) {
            if (a.getAppointmentId().equals(id)) {
                old = a;
                break;
            }
        }

        if (old == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("Select new doctor:");
        DataStore.displayDoctors();
        System.out.print("Doctor ID: ");
        String docId = scanner.nextLine();

        Doctor doctor = DataStore.getDoctorById(docId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        patient.removeAppointment(old);
        DataStore.removeAppointment(old);

        Appointment newAppt =
            new Appointment("A" + System.currentTimeMillis(), patient, doctor);

        patient.addAppointment(newAppt);
        DataStore.addAppointment(newAppt);

        System.out.println("Appointment rescheduled successfully.");
    }
}
