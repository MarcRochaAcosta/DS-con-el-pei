package vectorial;

public class Power extends BinaryOperator {
    private double exponent;

    public Power(Function base, double exponent) {
        super(base, null); // Only one argument is needed
        this.exponent = exponent;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        DualNumber base = left.evaluate(inputs);
        double[] newUprimeArray = new double[base.getUprimeArray().length];
        for (int i = 0; i < base.getUprimeArray().length; i++) {
            newUprimeArray[i] = exponent * Math.pow(base.getU(), exponent - 1) * base.getUprimeArray()[i];
        }
        return new DualNumber(Math.pow(base.getU(), exponent), newUprimeArray);
    }
}
