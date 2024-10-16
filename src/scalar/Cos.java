package scalar;

public class Cos implements Function {
    private Function func;

    public Cos(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.cos(dn1.getU()), -Math.sin(dn1.getU()) * dn1.getUprime());
    }
}