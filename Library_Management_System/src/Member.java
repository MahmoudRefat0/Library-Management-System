public class Member {
    private String name;
    private String memberId;
    private MembershipType type;
    private double debt;
    private int borrowedCount;

    public Member(String name, String memberId, MembershipType type) {
        this.name = name;
        this.memberId = memberId;
        this.type = type;
        this.debt = 0.0;
        this.borrowedCount = 0;
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public double getDebt() { return debt; }
    public int getBorrowedCount() { return borrowedCount; }

    public boolean canBorrow() {
        return borrowedCount < 3 && debt <= 100.0;
    }

    public void applyFine(double amount) {
        if (amount <= 0) return;
        double discountedFine = amount * (1.0 - type.getDiscount());
        this.debt += (discountedFine + LibraryItem.ADMIN_FEE);
    }

    public boolean payDebt(double amount) {
        if (amount > 0 && amount <= debt) {
            debt -= amount;
            return true;
        }
        return false;
    }

    public void incBorrowed() { borrowedCount++; }
    public void decBorrowed() { if (borrowedCount > 0) borrowedCount--; }

    public void showInfo() {
        System.out.println("ID: " + memberId + " | Name: " + name + " | Debt: " + debt + " EGP");
    }
}