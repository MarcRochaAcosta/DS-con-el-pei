package vectorial;

public class GradientDescent {
    public static double[] gradientDescent(Function func, double[] startPoint, double learningRate, int steps) {
        double[] currentPoint = startPoint.clone();

        for (int i = 0; i < steps; i++) {
            DualNumber[] input = new DualNumber[currentPoint.length];
            for (int j = 0; j < currentPoint.length; j++) {
                double[] derivatives = new double[currentPoint.length];
                derivatives[j] = 1.0; // Derivada parcial respecto a la variable actual
                input[j] = new DualNumber(currentPoint[j], derivatives);
            }

            DualNumber output = func.evaluate(input);
            for (int j = 0; j < currentPoint.length; j++) {
                currentPoint[j] -= learningRate * output.getUprimeArray()[j];
            }
        }

        return currentPoint;
    }
}
