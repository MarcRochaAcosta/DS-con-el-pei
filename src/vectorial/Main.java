package vectorial;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Evaluación de Funciones y Comparación de Derivadas ====");

        // Definir la nueva función f(x) = sin(pi/2 + x^2) / (x + 1)
        Function halfPi = new Constant(Math.PI / 2);
        Function x = new X(0); // x1
        Function power = new Power(x, 2); // x^2
        Function sinFunction = new Sin(new Add(halfPi, power)); // sin(pi/2 + x^2)
        Function denominator = new Add(x, new Constant(1)); // x + 1
        Function func1D = new Divide(sinFunction, denominator); // f(x)

        // Evaluar en x = 3.0
        double[] x_value = {3.0};
        DualNumber result = func1D.evaluate(toDualNumberArray(x_value));

        // Derivada numérica con epsilon
        double epsilon = 1e-6;
        double numericalDerivative = NumericalDerivative.derivative(func1D, x_value, epsilon);

        // Imprimir el valor de f(x) y la derivada automática
        System.out.printf("f(x) = sin(pi/2 + x^2) / (x + 1)\nf(%.1f) = %.10f%n", x_value[0], result.getU());
        System.out.printf("f'(%.1f) = %.10f%n", x_value[0], result.getUprimeArray()[0]);
        System.out.printf("Derivada numérica: %.10f%n", numericalDerivative);

        // Comparación de derivadas
        System.out.printf("Diferencia entre derivadas: %.10f%n", Math.abs(result.getUprimeArray()[0] - numericalDerivative));

        // Parte 2: Gradiente Descendente en 2D
        System.out.println("\n==== Gradiente Descendente en f(x1, x2) ====");

        // Definir la función f(x1, x2) = sin(pi/2 + x1^2) / (x2 + 1)
        Function x1 = new X(0); // x1
        Function x2 = new X(1); // x2
        Function power2D = new Power(x1, 2); // x1^2
        Function sinFunction2D = new Sin(new Add(halfPi, power2D)); // sin(pi/2 + x1^2)
        Function denominator2D = new Add(x2, new Constant(1)); // x2 + 1
        Function func2D = new Divide(sinFunction2D, denominator2D); // f(x1, x2)

        // Realizar gradiente descendente desde el punto (3.0, 3.0)
        double[] startPoint = {3.0, 3.0};
        double learningRate = 0.01;
        int steps = 100;

        double[] minimumPoint = GradientDescent.gradientDescent(func2D, startPoint, learningRate, steps);
        System.out.printf("Minimum point after gradient descent: [%s]%n", Arrays.toString(minimumPoint));

        // Evaluar la función en el punto mínimo
        DualNumber minimumResult = func2D.evaluate(toDualNumberArray(minimumPoint));
        System.out.printf("f(Minimum) = %.10f%n", minimumResult.getU());

        // Cálculo de Mínimos y Máximos en 2D
        double[] evalPoint = {3.0, 4.0}; // Ejemplo de evaluación en (3.0, 4.0)
        DualNumber evalResult = func2D.evaluate(toDualNumberArray(evalPoint));
        System.out.printf("f(%.1f, %.1f) = %.10f%n", evalPoint[0], evalPoint[1], evalResult.getU());

        // Calcular el gradiente en el punto (3.0, 4.0)
        System.out.printf("Gradiente en (%.1f, %.1f) = [%s]%n", evalPoint[0], evalPoint[1], Arrays.toString(evalResult.getUprimeArray()));
    }

    // Convertir un array de valores a un array de DualNumbers
    private static DualNumber[] toDualNumberArray(double[] point) {
        DualNumber[] dualNumbers = new DualNumber[point.length];
        for (int i = 0; i < point.length; i++) {
            double[] uprimeArray = new double[point.length];
            uprimeArray[i] = 1.0; // Derivada parcial respecto a la variable actual
            dualNumbers[i] = new DualNumber(point[i], uprimeArray);
        }
        return dualNumbers;
    }
}
