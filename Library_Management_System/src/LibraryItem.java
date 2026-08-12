public abstract class LibraryItem {
    protected String id;
    protected String title;
    protected ItemStatus status;
    protected String borrowerId;
    protected int renewals;

    public static final String LIB_NAME = "Bayt Al Hekma";
    public static final double ADMIN_FEE = 10.0;
    private static int totalItems = 0;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.status = ItemStatus.AVAILABLE;
        this.borrowerId = null;
        this.renewals = 0;
        totalItems++;
    }

    public abstract double getFine(int daysLate);
    public abstract int getLoanDays();
    public abstract String getType();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public ItemStatus getStatus() { return status; }
    public String getBorrowerId() { return borrowerId; }
    public static int getTotalItems() { return totalItems; }

    public boolean borrowItem(String memberId) {
        if (status == ItemStatus.AVAILABLE) {
            this.status = ItemStatus.BORROWED;
            this.borrowerId = memberId;
            return true;
        }
        return false;
    }

    public void returnItem() {
        this.status = ItemStatus.AVAILABLE;
        this.borrowerId = null;
        this.renewals = 0;
    }

    public void printDetails() {
        System.out.println("ID: " + id + " | Type: " + getType() + " | Title: " + title +
                " | Status: " + status + " | Borrower: " + (borrowerId == null ? "None" : borrowerId));
    }
}