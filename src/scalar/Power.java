package scalar;

public class Power implements Function {
    private Function base;
    private double exponent;

    public Power(Function base, double exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = base.evaluate(dn);
        return new DualNumber(Math.pow(dn1.getU(), exponent), exponent * Math.pow(dn1.getU(), exponent - 1) * dn1.getUprime());
    }
}