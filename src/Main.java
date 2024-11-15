import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       // testRegister();
      //  testLogin();
        testProduct();
    }



    private static void testProduct() {
        Product product1 = new Product("Πορτοκάλια 1kg", "Φρέσκα πορτοκάλια, ιδανικά για χυμό ή κατανάλωση.",
                1.20, "Φρέσκα τρόφιμα", "Φρούτα", 200);
        Product product2 = new Product("Καρότα 1kg", "Τραγανά καρότα, κατάλληλα για σαλάτες και μαγείρεμα.",
                1.00, "Φρέσκα τρόφιμα", "Λαχανικά", 150);

        product1.saveToFile();
        product2.saveToFile();
    }


    private static void testRegister() {
        Scanner scanner = new Scanner(System.in);
        RegistrationSystem regSystem = new RegistrationSystem();
       // regSystem.printer();
        for (User user : regSystem.getUserList()) {
            System.out.println(user.toString());
        }
        while(true)

        {
            System.out.println("=== Εγγραφή Χρήστη ===");
            System.out.print("Όνομα: ");
            String firstName = scanner.nextLine();

            System.out.print("Επίθετο: ");
            String lastName = scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Προσπάθεια εγγραφής του χρήστη
            if (regSystem.addUser(firstName, lastName, username, password)) {
                System.out.println("Ο λογαριασμός δημιουργήθηκε με επιτυχία!");
            } else {
                System.out.println("Το username '" + username + "' υπάρχει ήδη. Δοκιμάστε άλλο.");
            }

            System.out.println("Θέλετε να εγγραφεί άλλος χρήστης; (ναι/όχι)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("ναι")) {
                break;
            }
        }
        scanner.close();
        // regSystem.printer();
    }

    private static void testLogin() {
        RegistrationSystem regSystem = new RegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();
        while(true){

        System.out.println("\nΔοκιμή σύνδεσης χρηστών:");

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        loginSystem.login(regSystem.getUserList(), username, password);

        System.out.println("...");
        loginSystem.logout();
    }
        }
}