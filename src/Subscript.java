public class Subscript implements Function {
    private int index;

    public Subscript(int index) {
        this.index = index - 1;
    }

    @Override
    public DualNumber evaluate(double[] x) {
        double[] uprime = new double[x.length];
        uprime[index] = 1.0;  // Inicializa la derivada de x_i como 1
        return new DualNumber(x[index], uprime);
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        return null;  // No se usa en este contexto
    }
}
