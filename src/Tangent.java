public class Tangent implements Function {
    private Function func;

    public Tangent(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber result = func.evaluate(dn);
        return new DualNumber(Math.tan(result.getU()), result.getUprime() / (1 + Math.pow(result.getU(), 2)));
    }

    @Override
    public DualNumber evaluate(double[] x) {
        return null;
    }
}