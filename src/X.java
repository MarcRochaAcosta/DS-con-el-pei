public class X implements Function {
    public X() {}

    @Override
    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(dn.u, 1.0); // La derivada de x es 1
    }

    @Override
    public DualNumber evaluate(double[] x) {
        return null; // No usado aquí
    }
}