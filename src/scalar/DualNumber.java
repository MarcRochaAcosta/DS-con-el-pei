package scalar;

public class DualNumber {
    public double getU;
    private double u;
    private double uprime;

    public DualNumber(double u, double uprime) {
        this.u = u;
        this.uprime = uprime;
    }

    public double getU() {
        return u;
    }

    public double getUprime() {
        return uprime;
    }
}