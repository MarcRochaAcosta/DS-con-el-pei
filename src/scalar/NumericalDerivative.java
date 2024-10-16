package scalar;

public class NumericalDerivative {
    public static double derivative(Function f, double x) {
        double h = 1e-5;
        DualNumber dn1 = new DualNumber(x, 1.0);
        DualNumber dn2 = f.evaluate(dn1);
        DualNumber dn3 = f.evaluate(new DualNumber(x + h, 0));
        return (dn3.getU() - dn2.getU()) / h;
    }
}