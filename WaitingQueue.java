import java.util.LinkedList;
import java.util.Queue;

public class WaitingQueue {

    private static final Queue<Patient> queue = new LinkedList<>();

    public static void addPatient(Patient patient) {
        queue.offer(patient);
    }

    public static Patient getNextPatient() {
        return queue.poll();
    }

    public static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return;
        }

        for (Patient p : queue) {
            System.out.println(p.getId() + " | " + p.getName());
        }
    }
}
