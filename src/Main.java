import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Parte 1: Comparar Derivadas
        System.out.println("==== Comparación de Derivadas ====");

        // Definir la función f(x) = sin(pi/2 + x^2)
        Function halfPi = new Constant(Math.PI / 2);
        Function x = new X();
        Function func = new Sin(new Add(halfPi, new Multiply(x, x)));

        // Evaluar en x = 4.0
        double x_value = 4.0;
        DualNumber exactResult = func.evaluate(new DualNumber(x_value, 1.0));

        // Derivada numérica con diferentes epsilon
        double epsilon = 1e-6;
        double numericalDerivative = NumericalDerivative.derivative(func, x_value, epsilon);

        // Derivada exacta (manual)
        double trueDerivative = 2 * x_value * Math.sin(x_value) + x_value * Math.cos(x_value);

        // Imprimir resultados
        System.out.println("Exact Derivative (Automatic): " + exactResult.uprime);
        System.out.println("Numerical Derivative: " + numericalDerivative);
        System.out.println("True Derivative: " + trueDerivative);

        // Calcular errores
        double errorNumerical = Math.abs(exactResult.uprime - numericalDerivative);
        double errorTrue = Math.abs(exactResult.uprime - trueDerivative);
        System.out.println("Error between Automatic and Numerical: " + errorNumerical);
        System.out.println("Error between Automatic and True: " + errorTrue);

        // Parte 2: Gradiente Descendente
        System.out.println("\n==== Gradiente Descendente en f(x1, x2) ====");

        // Definir la función f(x1, x2) = x1^2 + 0.5*x2^2
        Function x1 = new Subscript(1);
        Function x2 = new Subscript(2);
        Function func2D = new Add(new Multiply(x1, x1), new Multiply(new Constant(0.5), new Multiply(x2, x2)));

        // Realizar gradiente descendente desde el punto (2.0, 3.0)
        double[] startPoint = {2.0, 3.0};
        double learningRate = 0.01;
        int steps = 20;


        double[] minimumPoint = GradientDescent.gradientDescent(func2D, startPoint, learningRate, steps);

        // Imprimir el resultado del punto mínimo
        System.out.println("Minimum point after gradient descent: " + Arrays.toString(minimumPoint));
    }
}
