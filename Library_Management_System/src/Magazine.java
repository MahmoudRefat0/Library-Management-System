public class Magazine extends LibraryItem implements Renewable {
    private int issueNo;

    public Magazine(String id, String title, int issueNo) {
        super(id, title);
        this.issueNo = issueNo;
    }

    @Override
    public double getFine(int daysLate) {
        double totalFine = daysLate * 3.0;
        return totalFine > 30.0 ? 30.0 : totalFine;
    }

    @Override
    public int getLoanDays() { return 7; }

    @Override
    public String getType() { return "Magazine"; }

    @Override
    public boolean renew() {
        if (getStatus() == ItemStatus.BORROWED && renewals < getMaxRenewals()) {
            renewals++;
            return true;
        }
        return false;
    }

    @Override
    public int getMaxRenewals() { return 1; }
}