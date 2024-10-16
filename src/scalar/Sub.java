package scalar;

public class Sub extends BinaryOperator {
    public Sub(Function left, Function right) {
        super(left, right);
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.getU() - dn2.getU(), dn1.getUprime() - dn2.getUprime());
    }
}