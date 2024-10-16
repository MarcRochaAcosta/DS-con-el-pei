package vectorial;

public class Square extends Function {
    private Function function;

    public Square(Function function) {
        this.function = function;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        DualNumber result = function.evaluate(inputs);
        double[] newUprimeArray = new double[result.uprimeArray.length];
        for (int i = 0; i < result.uprimeArray.length; i++) {
            newUprimeArray[i] = 2 * result.u * result.uprimeArray[i];
        }
        return new DualNumber(Math.pow(result.u, 2), newUprimeArray);
    }
}
