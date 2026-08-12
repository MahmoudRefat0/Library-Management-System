public enum MembershipType {
    STUDENT(0.20),
    FACULTY(0.50),
    REGULAR(0.00);

    private final double discount;

    MembershipType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}