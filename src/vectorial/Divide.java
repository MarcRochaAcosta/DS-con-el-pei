package vectorial;

public class Divide extends BinaryOperator {
    public Divide(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return left.evaluate(inputs).divide(right.evaluate(inputs));
    }
}
