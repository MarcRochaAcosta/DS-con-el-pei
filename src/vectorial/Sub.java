package vectorial;

public class Sub extends BinaryOperator {
    public Sub(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return left.evaluate(inputs).subtract(right.evaluate(inputs));
    }
}
