import java.util.Scanner;

public class HomeVisitRequestPage {

    public static void request(Patient patient, Scanner scanner) {

        System.out.println("\n--- Home Visit Request ---");
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.println("Home visit request placed for " + address);
        System.out.println("Request added to processing queue.");
    }
}
