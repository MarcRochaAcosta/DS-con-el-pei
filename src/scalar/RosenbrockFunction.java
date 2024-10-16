package scalar;

public class RosenbrockFunction implements Function {
    @Override
    public DualNumber evaluate(DualNumber dn) {
        double x = dn.getU();
        return new DualNumber(100 * Math.pow((x * x - 1), 2) + Math.pow((x - 1), 2), 0);
    }
}
