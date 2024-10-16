public class RosenbrockFunction implements Function {
    private double a;
    private double b;

    public RosenbrockFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        return null;
    }

    @Override
    public DualNumber evaluate(double[] x) {
        int numDimensions = x.length;
        double[] uprime = new double[numDimensions];
        double u = (1 - x[0]) * (1 - x[0]) + b * (x[1] - x[0] * x[0]) * (x[1] - x[0] * x[0]);
        uprime[0] = -4 * (1 - x[0]) * x[0] - 4 * b * x[0] * (x[1] - x[0] * x[0]);
        uprime[1] = 2 * b * (x[1] - x[0] * x[0]);
        return new DualNumber(u, uprime);
    }
}