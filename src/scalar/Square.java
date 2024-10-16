package scalar;

public class Square implements Function {
    private Function func;

    public Square(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.pow(dn1.getU(), 2), 2 * dn1.getU() * dn1.getUprime());
    }
}