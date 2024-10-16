package vectorial;

public abstract class BinaryOperator extends Function {
    protected Function left;
    protected Function right;

    public BinaryOperator(Function left, Function right) {
        this.left = left;
        this.right = right;
    }
}
