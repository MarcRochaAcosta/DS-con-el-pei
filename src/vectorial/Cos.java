package vectorial;

public class Cos extends Function {
    private Function function;

    public Cos(Function function) {
        this.function = function;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        DualNumber result = function.evaluate(inputs);
        double[] newUprimeArray = new double[result.uprimeArray.length];
        for (int i = 0; i < result.uprimeArray.length; i++) {
            newUprimeArray[i] = -Math.sin(result.u) * result.uprimeArray[i];
        }
        return new DualNumber(Math.cos(result.u), newUprimeArray);
    }
}
