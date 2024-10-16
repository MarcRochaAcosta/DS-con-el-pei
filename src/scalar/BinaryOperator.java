package scalar;

public abstract class BinaryOperator implements Function {
    protected Function left;
    protected Function right;

    public BinaryOperator(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    // Implementar en subclases
    public abstract DualNumber evaluate(DualNumber dn);
}