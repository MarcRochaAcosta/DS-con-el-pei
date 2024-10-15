public class X extends Function {
    @Override
    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(dn.getU(), 1.0);
    }
}
