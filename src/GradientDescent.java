public class GradientDescent {
    public static double[] gradientDescent(Function func, double[] startPoint, double learningRate, int steps) {
        double[] point = startPoint.clone();

        for (int i = 0; i < steps; i++) {
            DualNumber dn = func.evaluate(point);

            // Verificar que dn.uprimeArray no sea null
            if (dn.uprimeArray == null) {
                throw new NullPointerException("uprimeArray es null en la iteración " + i);
            }

            for (int j = 0; j < point.length; j++) {
                point[j] -= learningRate * dn.uprimeArray[j];
            }
        }

        return point;
    }
}
