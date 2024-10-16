package vectorial;

public class Subscript extends Function {
    private int index;

    public Subscript(int index) {
        this.index = index;
    }

    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        return inputs[index];
    }
}
