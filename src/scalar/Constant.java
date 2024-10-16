package scalar;

public class Constant implements Function {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(value, 0.0);
    }
}