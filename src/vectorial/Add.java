package vectorial;

public class Add extends BinaryOperator {
    public Add(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return left.evaluate(inputs).add(right.evaluate(inputs));
    }
}
