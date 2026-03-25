import java.util.Scanner;

public class ReceptionistRegisterPage {

    public static void register(Scanner scanner) {

        System.out.println("\n--- Receptionist Registration ---");

        System.out.print("Enter Receptionist ID: ");
        String id = scanner.nextLine();

        if (DataStore.getReceptionistById(id) != null) {
            System.out.println("Receptionist ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Receptionist receptionist = new Receptionist(id, name, password);
        DataStore.addReceptionist(receptionist);

        System.out.println("Receptionist registered successfully.");
    }
}
