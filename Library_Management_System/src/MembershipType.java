public enum MembershipType {
    STUDENT(0.25),
    STAFF(0.10),
    PUBLIC(0.00);

    private final double discount;

    MembershipType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}