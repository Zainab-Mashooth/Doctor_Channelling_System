import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

    private int age;
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String id, String name, String password, int age) {
        super(id, name, password);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public void removeAppointment(Appointment a) {
        appointments.remove(a);
    }
}
