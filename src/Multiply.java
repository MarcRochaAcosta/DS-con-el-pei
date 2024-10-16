public class Multiply extends BinaryOperator {
    public Multiply(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.u * dn2.u, dn1.uprime * dn2.u + dn1.u * dn2.uprime);
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber dn1 = left.evaluate(x);
        DualNumber dn2 = right.evaluate(x);

        // Validación adicional
        if (dn1.uprimeArray == null || dn2.uprimeArray == null) {
            throw new NullPointerException("Multiply: uprimeArray es null en alguna función.");
        }

        double[] uprimeArray = new double[x.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            uprimeArray[i] = dn1.uprimeArray[i] * dn2.u + dn1.u * dn2.uprimeArray[i];
        }
        return new DualNumber(dn1.u * dn2.u, uprimeArray);
    }
}
