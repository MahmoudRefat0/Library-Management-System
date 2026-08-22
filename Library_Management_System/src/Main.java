import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library(50, 50);
        Scanner sc = new Scanner(System.in);

        lib.addItem(new Book("B101", "Java How to Program", "Deitel", 1200));
        lib.addItem(new Magazine("M201", "Tech Monthly", 105));
        lib.addItem(new DVD("D301", "Inception", 148));

        lib.addMember(new Member("Ali", "MEM1", MembershipType.STUDENT));
        lib.addMember(new Member("Omar", "MEM2", MembershipType.STAFF, 50.0));

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Bayt Al Hekma Library System ---");
            System.out.println("1. View catalogue");
            System.out.println("2. Register member");
            System.out.println("3. Borrow item");
            System.out.println("4. Return item");
            System.out.println("5. Renew loan");
            System.out.println("6. Search item by ID");
            System.out.println("7. View items by status");
            System.out.println("8. Pay outstanding fines");
            System.out.println("9. View all members");
            System.out.println("10. Library report");
            System.out.println("11. Mark item as lost");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    lib.showAllItems();
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter member ID: ");
                    String memId = sc.nextLine();
                    System.out.println("Select type (1: STUDENT, 2: STAFF, 3: PUBLIC): ");
                    int tChoice = sc.nextInt();
                    MembershipType type = MembershipType.PUBLIC;
                    if (tChoice == 1) type = MembershipType.STUDENT;
                    else if (tChoice == 2) type = MembershipType.STAFF;

                    if (lib.addMember(new Member(name, memId, type))) {
                        System.out.println("Member added successfully!");
                    } else {
                        System.out.println("Failed to add member.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    String bItemId = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String bMemId = sc.nextLine();
                    if (lib.processBorrow(bItemId, bMemId)) {
                        System.out.println("Item borrowed successfully!");
                    } else {
                        System.out.println("Borrowing failed!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    String rItemId = sc.nextLine();
                    System.out.print("Enter overdue days: ");
                    int daysLate = sc.nextInt();
                    if (lib.processReturn(rItemId, daysLate)) {
                        System.out.println("Item returned successfully!");
                    } else {
                        System.out.println("Return failed!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Item ID to renew: ");
                    String renewId = sc.nextLine();
                    LibraryItem renewItem = lib.findItem(renewId);
                    if (renewItem instanceof Renewable) {
                        if (((Renewable) renewItem).renew()) {
                            System.out.println("Loan renewed successfully!");
                        } else {
                            System.out.println("Renewal limit reached or item not on loan.");
                        }
                    } else {
                        System.out.println("This item type cannot be renewed.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Item ID: ");
                    String sId = sc.nextLine();
                    LibraryItem found = lib.findItem(sId);
                    if (found != null) {
                        found.printDetails();
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 7:
                    System.out.println("Select status (1: AVAILABLE, 2: ON_LOAN, 3: LOST): ");
                    int stChoice = sc.nextInt();
                    ItemStatus st = ItemStatus.AVAILABLE;
                    if (stChoice == 2) st = ItemStatus.ON_LOAN;
                    else if (stChoice == 3) st = ItemStatus.LOST;

                    boolean itemFound = false;
                    for (int i = 0; i < LibraryItem.getTotalItems(); i++) {
                        // Display items matching status
                    }
                    System.out.println("Filter applied for status: " + st);
                    break;

                case 8:
                    System.out.print("Enter Member ID: ");
                    String pMemId = sc.nextLine();
                    Member pMember = lib.findMember(pMemId);
                    if (pMember != null) {
                        System.out.print("Enter payment amount: ");
                        double amt = sc.nextDouble();
                        if (pMember.payDebt(amt)) {
                            System.out.println("Payment accepted!");
                        } else {
                            System.out.println("Invalid amount!");
                        }
                    } else {
                        System.out.println("Member not found!");
                    }
                    break;

                case 9:
                    lib.showAllMembers();
                    break;

                case 10:
                    System.out.println("Library Name: " + LibraryItem.LIB_NAME);
                    System.out.println("Total Items Created: " + LibraryItem.getTotalItems());
                    break;

                case 11:
                    System.out.print("Enter Item ID to mark as lost: ");
                    String lId = sc.nextLine();
                    LibraryItem lItem = lib.findItem(lId);
                    if (lItem != null && lItem.markAsLost()) {
                        System.out.println("Item status updated to LOST.");
                    } else {
                        System.out.println("Cannot mark as lost (Item must be AVAILABLE).");
                    }
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}