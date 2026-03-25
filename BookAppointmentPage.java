import java.util.Scanner;

public class BookAppointmentPage {

    public static void book(Patient patient, Scanner scanner) {

        System.out.println("\n--- Book Appointment ---");
        DataStore.displayDoctors();

        System.out.print("Enter Doctor ID: ");
        String docId = scanner.nextLine();

        Doctor doctor = DataStore.getDoctorById(docId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        String appointmentId = "A" + System.currentTimeMillis();
        Appointment appointment = new Appointment(appointmentId, patient, doctor);

        DataStore.addAppointment(appointment);
        patient.addAppointment(appointment);

        System.out.println("Appointment booked successfully.");
    }
}
