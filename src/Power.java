public class Power implements Function {
    private Function func;
    private double exponent;

    public Power(Function func, double exponent) {
        this.func = func;
        this.exponent = exponent;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.pow(dn1.getU(), exponent),
                exponent * Math.pow(dn1.getU(), exponent - 1) * dn1.getUprime());
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber dn1 = func.evaluate(x);
        double[] uprimeArray = new double[x.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            uprimeArray[i] = exponent * Math.pow(dn1.getU(), exponent - 1) * dn1.uprimeArray[i];
        }
        return new DualNumber(Math.pow(dn1.getU(), exponent), uprimeArray);
    }
}
