package scalar;

public class Divide implements Function {
    private Function numerator;
    private Function denominator;

    public Divide(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = numerator.evaluate(dn);
        DualNumber dn2 = denominator.evaluate(dn);
        double u = dn1.getU() / dn2.getU();
        double uprime = (dn1.getUprime() * dn2.getU() - dn1.getU() * dn2.getUprime()) / (dn2.getU() * dn2.getU());
        return new DualNumber(u, uprime);
    }
}