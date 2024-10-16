package vectorial;

public class RosenbrockFunction extends Function {
    @Override
    public DualNumber evaluate(DualNumber[] inputs) {
        double x1 = inputs[0].getU();
        double x2 = inputs[1].getU();

        double[] uprimeArray = new double[2];
        uprimeArray[0] = -2 * (1 - x1) - 400 * x1 * (x2 - x1 * x1); // Parcial respecto a x1
        uprimeArray[1] = 200 * (x2 - x1 * x1);                       // Parcial respecto a x2

        double u = (1 - x1) * (1 - x1) + 100 * (x2 - x1 * x1) * (x2 - x1 * x1);

        return new DualNumber(u, uprimeArray);
    }
}
