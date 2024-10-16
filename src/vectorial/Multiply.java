package vectorial;

public class Multiply extends BinaryOperator {
    public Multiply(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return left.evaluate(inputs).multiply(right.evaluate(inputs));
    }
}
