package vectorial;

public class Sin extends Function {
    private Function function;

    public Sin(Function function) {
        this.function = function;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        DualNumber result = function.evaluate(inputs);
        double[] newUprimeArray = new double[result.uprimeArray.length];
        for (int i = 0; i < result.uprimeArray.length; i++) {
            newUprimeArray[i] = Math.cos(result.u) * result.uprimeArray[i];
        }
        return new DualNumber(Math.sin(result.u), newUprimeArray);
    }
}
