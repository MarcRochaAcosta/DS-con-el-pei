public class Add extends BinaryOperator {
    public Add(Function left, Function right) {
        super(left, right);
    }

    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.u + dn2.u, dn1.uprime + dn2.uprime);
    }

    @Override
    public DualNumber evaluate(double[] x) {
        // Create a new DualNumber with the value of the left function evaluated at x
        DualNumber dn1 = left.evaluate(x);
        // Create a new DualNumber with the value of the right function evaluated at x
        DualNumber dn2 = right.evaluate(x);
        // Return a new DualNumber with the sum of the values of the two DualNumbers
        return new DualNumber(dn1.u + dn2.u, dn1.uprime + dn2.uprime);
    }
}