public class DVD extends LibraryItem {
    private int duration;

    public DVD(String id, String title, int duration) {
        super(id, title);
        this.duration = duration;
    }

    public int getDuration() { return duration; }

    @Override
    public double getFine(int daysLate) {
        return daysLate * 15.0;
    }

    @Override
    public int getLoanDays() { return 3; }

    @Override
    public String getType() { return "DVD"; }
}