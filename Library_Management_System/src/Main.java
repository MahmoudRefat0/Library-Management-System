import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library(20, 20);
        Scanner in = new Scanner(System.in);

        // Dummy data
        lib.addItem(new Book("B1", "Java Basics", "John", 300));
        lib.addItem(new Magazine("M1", "Tech World", 5));
        lib.addMember(new Member("Mahmoud", "U1", MembershipType.STUDENT));

        int option = -1;
        while (option != 0) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Items");
            System.out.println("2. Show Members");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            option = in.nextInt();
            in.nextLine();

            if (option == 1) {
                lib.showAllItems();
            } else if (option == 2) {
                lib.showAllMembers();
            } else if (option == 3) {
                System.out.print("Item ID: "); String iId = in.nextLine();
                System.out.print("Member ID: "); String mId = in.nextLine();
                if (lib.processBorrow(iId, mId)) System.out.println("Done!");
                else System.out.println("Failed!");
            } else if (option == 4) {
                System.out.print("Item ID: "); String iId = in.nextLine();
                System.out.print("Days Late: "); int days = in.nextInt();
                if (lib.processReturn(iId, days)) System.out.println("Returned!");
                else System.out.println("Failed!");
            }
        }
    }
}