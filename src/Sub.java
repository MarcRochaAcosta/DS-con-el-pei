public class Sub implements Function {
    private Function func1;
    private Function func2;

    public Sub(Function func1, Function func2) {
        this.func1 = func1;
        this.func2 = func2;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func1.evaluate(dn);
        DualNumber dn2 = func2.evaluate(dn);
        return new DualNumber(dn1.getU() - dn2.getU(), dn1.getUprime() - dn2.getUprime());
    }

    @Override
    public DualNumber evaluate(double[] x) {
        return null;
    }
}
