public class Subscript implements Function {
    private int index;

    public Subscript(int index) {
        this.index = index - 1;
    }

    public DualNumber evaluate(double[] x) {
        double[] uprime = new double[x.length];
        uprime[index] = 1.0;
        return new DualNumber(x[index], uprime);
    }

    public DualNumber evaluate(DualNumber dn) {
        return null; // No se usa en el contexto de variables
    }
}