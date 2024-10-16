package vectorial;

public class NumericalDerivative {
    public static double derivative(Function f, double[] x, double epsilon) {
        double[] xPlusEpsilon = x.clone();
        for (int i = 0; i < x.length; i++) {
            xPlusEpsilon[i] += epsilon;
        }

        DualNumber[] dualX = toDualNumberArray(x);
        DualNumber[] dualXPlusEpsilon = toDualNumberArray(xPlusEpsilon);

        double fX = f.evaluate(dualX).getU();
        double fXPlusEpsilon = f.evaluate(dualXPlusEpsilon).getU();

        return (fXPlusEpsilon - fX) / epsilon;
    }

    private static DualNumber[] toDualNumberArray(double[] point) {
        DualNumber[] dualNumbers = new DualNumber[point.length];
        for (int i = 0; i < point.length; i++) {
            dualNumbers[i] = new DualNumber(point[i], new double[point.length]);
        }
        return dualNumbers;
    }
}
