public class Power extends Function {
    private Function func;
    private double exponent;

    public Power(Function func, double exponent) {
        this.func = func;
        this.exponent = exponent;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.pow(dn1.getU(), exponent), exponent * Math.pow(dn1.getU(), exponent - 1) * dn1.getUprime());
    }
}
