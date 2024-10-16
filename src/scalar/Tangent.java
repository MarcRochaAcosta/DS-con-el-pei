package scalar;

public class Tangent implements Function {
    private Function func;

    public Tangent(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.tan(dn1.getU()), (1 / Math.cos(dn1.getU()) * Math.cos(dn1.getU)) * dn1.getUprime());
    }
}
