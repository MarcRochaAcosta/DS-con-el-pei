package vectorial;

public class X extends Function {
    private int index;

    public X(int index) {
        this.index = index;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return inputs[index];
    }
}
