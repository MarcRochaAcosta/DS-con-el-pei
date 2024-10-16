public class GradientDescent {
    // Function to perform Gradient Descent on a function
    public static double[] gradientDescent(Function func, double[] startPoint, double learningRate, int steps) {
        // Copy the starting point to avoid modifying the original
        double[] point = startPoint.clone();

        // Iterate for the specified number of steps
        for (int i = 0; i < steps; i++) {
            // Evaluate the function at the current point
            DualNumber dn = func.evaluate(point);
            // Update each coordinate of the point using the gradient
            // (Note: the code assumes that the 'func' is a function of multiple variables,
            // and that `evaluate()` returns a `DualNumber` object with a `uprimeArray` containing the partial derivatives)
            for (int j = 0; j < point.length; j++) {
                point[j] = learningRate * dn.uprimeArray[j];
            }
        }
        // Return the final point after the gradient descent steps
        return point;
    }
}