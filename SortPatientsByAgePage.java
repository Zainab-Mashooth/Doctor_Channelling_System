import java.util.*;

public class SortPatientsByAgePage {

    public static void sortAndDisplay() {

        List<Patient> list = DataStore.getPatients();
        list.sort(Comparator.comparingInt(Patient::getAge));

        System.out.println("\n--- Patients Sorted by Age ---");
        for (Patient p : list) {
            System.out.println(p.getName() + " | Age: " + p.getAge());
        }
    }
}
