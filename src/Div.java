public class Div implements Function {
    private Function func1;
    private Function func2;

    public Div(Function func1, Function func2) {
        this.func1 = func1;
        this.func2 = func2;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func1.evaluate(dn);
        DualNumber dn2 = func2.evaluate(dn);
        return new DualNumber(dn1.getU() / dn2.getU(),
                (dn1.getUprime() * dn2.getU() - dn1.getU() * dn2.getUprime()) / (dn2.getU() * dn2.getU()));
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber dn1 = func1.evaluate(x);
        DualNumber dn2 = func2.evaluate(x);
        double[] uprimeArray = new double[x.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            uprimeArray[i] = (dn1.uprimeArray[i] * dn2.u - dn1.u * dn2.uprimeArray[i]) / (dn2.u * dn2.u);
        }
        return new DualNumber(dn1.u / dn2.u, uprimeArray);
    }
}
