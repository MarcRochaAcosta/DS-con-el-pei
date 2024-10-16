public class Square implements Function {
    private Function func;

    public Square(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber result = func.evaluate(dn);
        return new DualNumber(Math.pow(result.getU(), 2),
                2 * result.getU() * result.getUprime());
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber result = func.evaluate(x);
        double[] uprimeArray = new double[x.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            uprimeArray[i] = 2 * result.u * result.uprimeArray[i];
        }
        return new DualNumber(Math.pow(result.getU(), 2), uprimeArray);
    }
}
