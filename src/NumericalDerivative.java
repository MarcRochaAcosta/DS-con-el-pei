public class NumericalDerivative {
    public static double derivative(Function f, double x, double epsilon) {
        DualNumber dn1 = new DualNumber(x + epsilon, 0.0);
        DualNumber dn2 = new DualNumber(x, 0.0);
        double f_x_plus_epsilon = f.evaluate(dn1).u;
        double f_x = f.evaluate(dn2).u;
        return (f_x_plus_epsilon - f_x) / epsilon;
    }
}