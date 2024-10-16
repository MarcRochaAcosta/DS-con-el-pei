package scalar;

public class Sin implements Function {
    private Function func;

    public Sin(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.sin(dn1.getU()), Math.cos(dn1.getU()) * dn1.getUprime());
    }
}