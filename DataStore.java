import java.util.ArrayList;
import java.util.List;

public class DataStore {

    // ===================== DATA LISTS =====================
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Receptionist> receptionists = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();

    // ===================== SAMPLE DOCTORS =====================
    static {
        doctors.add(new Doctor("D001", "Dr. Perera", "Cardiology"));
        doctors.add(new Doctor("D002", "Dr. Silva", "Dermatology"));
        doctors.add(new Doctor("D003", "Dr. Fernando", "Neurology"));
    }

    // ===================== PATIENT METHODS =====================
    public static Patient getPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static List<Patient> getPatients() {
        return patients;
    }

    public static void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        for (Patient p : patients) {
            System.out.println(
                p.getId() + " | " +
                p.getName() + " | Age: " +
                p.getAge()
            );
        }
    }

    // ===================== RECEPTIONIST METHODS =====================
    public static Receptionist getReceptionistById(String id) {
        for (Receptionist r : receptionists) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public static void addReceptionist(Receptionist receptionist) {
        receptionists.add(receptionist);
    }

    // ===================== DOCTOR METHODS =====================
    public static void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public static Doctor getDoctorById(String id) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(
                d.getDoctorId() + " | " +
                d.getName() + " | " +
                d.getSpecialization()
            );
        }
    }

    // ===================== APPOINTMENT METHODS =====================
    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public static void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(
                a.getAppointmentId() + " | " +
                a.getPatient().getName() + " | " +
                a.getDoctor().getName()
            );
        }
    }
}
