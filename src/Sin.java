public class Sin implements Function {
    private Function func;

    public Sin(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.sin(dn1.u), Math.cos(dn1.u) * dn1.uprime);
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber dn1 = func.evaluate(x);
        int len = dn1.uprimeArray.length;
        double[] uprimeArray = new double[len];
        for (int i = 0; i < len; i++) {
            uprimeArray[i] = Math.cos(dn1.u) * dn1.uprimeArray[i];
        }
        return new DualNumber(Math.sin(dn1.u), uprimeArray);
    }
}
