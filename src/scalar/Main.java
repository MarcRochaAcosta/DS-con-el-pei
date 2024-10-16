package scalar;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Parte 1: Comparar Derivadas
        System.out.println("==== Comparación de Derivadas ====");

        // Definir la función f(x) = sin(pi/2 + x^2)
        Function halfPi = new Constant(Math.PI / 2);
        Function x = new X(); // Variable x
        Function func = new Sin(new Add(halfPi, new Multiply(x, x))); // f(x) = sin(pi/2 + x^2)

        // Evaluar en x = 3.0
        double x_value = 3.0;
        DualNumber exactResult = func.evaluate(new DualNumber(x_value, 1.0));

        // Derivada numérica con un epsilon
        double epsilon = 1e-6;
        double numericalDerivative = NumericalDerivative.derivative(func, x_value);

        // Derivada exacta (manual)
        double trueDerivative = Math.cos(x_value * x_value + Math.PI / 2) * 2 * x_value;

        // Imprimir resultados
        System.out.printf("f(x) = sin(pi/2 + x^2)\nf(%.1f) = %.10f%n", x_value, exactResult.getU());
        System.out.printf("Exact Derivative (Automatic): %.10f%n", exactResult.getUprime());
        System.out.printf("Numerical Derivative: %.10f%n", numericalDerivative);
        System.out.printf("True Derivative: %.10f%n", trueDerivative);

        // Calcular errores
        double errorNumerical = Math.abs(exactResult.getUprime() - numericalDerivative);
        double errorTrue = Math.abs(exactResult.getUprime() - trueDerivative);
        System.out.printf("Error between Automatic and Numerical: %.10f%n", errorNumerical);
        System.out.printf("Error between Automatic and True: %.10f%n", errorTrue);

        // Parte 2: Gradiente Descendente
        System.out.println("\n==== Gradiente Descendente en f(x1, x2) ====");

        // Definir la función f(x1, x2) = x1^2 + 0.5*x2^2
        Function x1 = new Subscript(new X(), 1); // x1
        Function x2 = new Subscript(new X(), 2); // x2
        Function func2D = new Add(new Multiply(x1, x1), new Multiply(new Constant(0.5), new Multiply(x2, x2))); // f(x1, x2)

        // Realizar gradiente descendente desde el punto (3.0, 4.0)
        double[] startPoint = {3.0, 4.0};
        double learningRate = 0.01;
        int steps = 100;

        double[] minimumPoint = GradientDescent.gradientDescent(func2D, startPoint, learningRate, steps); // Asegúrate de que esta clase existe

        // Imprimir el resultado del punto mínimo
        System.out.printf("Minimum point after gradient descent: %s%n", Arrays.toString(minimumPoint));

        // Evaluar la función en el punto mínimo
        DualNumber minimumResult = func2D.evaluate(new DualNumber(minimumPoint[0], 1.0)); // Evaluar x1
        minimumResult = func2D.evaluate(new DualNumber(minimumPoint[1], 1.0)); // Evaluar x2
        System.out.printf("f(Minimum) = %.10f%n", minimumResult.getU());

        // Calcular el gradiente en el punto mínimo
        System.out.printf("Gradiente en (%.1f, %.1f) = [%.10f, %.10f]%n", minimumPoint[0], minimumPoint[1],
                minimumResult.getUprime(), 0.0); // Aquí puedes ajustar para calcular el gradiente real si tienes esa implementación
    }

    // Convertir un array de valores a un solo DualNumber
    private static DualNumber toDualNumber(double value) {
        return new DualNumber(value, 1.0); // Derivada parcial respecto a la variable actual
    }
}
