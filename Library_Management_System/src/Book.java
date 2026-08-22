public class Book extends LibraryItem implements Renewable {
    private String author;
    private int pages;

    public Book(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() { return author; }
    public int getPages() { return pages; }

    @Override
    public double getFine(int daysLate) {
        return daysLate * 5.0;
    }

    @Override
    public int getLoanDays() { return 14; }

    @Override
    public String getType() { return "Book"; }

    @Override
    public boolean renew() {
        if (getStatus() == ItemStatus.ON_LOAN && renewals < getMaxRenewals()) {
            renewals++;
            return true;
        }
        return false;
    }

    @Override
    public int getMaxRenewals() { return 2; }
}