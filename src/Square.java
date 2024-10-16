public class Square implements Function {
    private Function func;

    public Square(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber result = func.evaluate(dn);
        return new DualNumber(Math.pow(result.getU(), 2), 2 * result.getU() * result.getUprime());
    }

    @Override
    public DualNumber evaluate(double[] x) {
        return null;
    }
}