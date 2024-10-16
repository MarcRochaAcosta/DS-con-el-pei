package scalar;

public class Add implements Function {
    private Function left;
    private Function right;

    public Add(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.getU() + dn2.getU(), dn1.getUprime() + dn2.getUprime());
    }
}
