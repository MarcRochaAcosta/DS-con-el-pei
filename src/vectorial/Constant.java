package vectorial;

public class Constant extends Function {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return new DualNumber(value, new double[inputs.length]); // Derivada cero en todas las variables
    }
}
