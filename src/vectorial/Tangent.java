package vectorial;

public class Tangent extends Function {
    private Function function;

    public Tangent(Function function) {
        this.function = function;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        DualNumber result = function.evaluate(inputs);
        double[] newUprimeArray = new double[result.uprimeArray.length];
        for (int i = 0; i < result.uprimeArray.length; i++) {
            newUprimeArray[i] = result.uprimeArray[i] / (Math.cos(result.u) * Math.cos(result.u));
        }
        return new DualNumber(Math.tan(result.u), newUprimeArray);
    }
}
