public abstract class BinaryOperator implements Function {
    protected Function left;
    protected Function right;

    public BinaryOperator(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    public abstract DualNumber evaluate(DualNumber dn);
    public DualNumber evaluate(double[] x) {
        // Crear un nuevo DualNumber con el valor de la función izquierda evaluada en x
        DualNumber dn1 = left.evaluate(x);

        // Crear un nuevo DualNumber con el valor de la función derecha evaluada en x
        DualNumber dn2 = right.evaluate(x);

        // Sumar los valores escalares u
        double newU = dn1.u + dn2.u;

        // Sumar los arrays uprime elemento por elemento
        double[] newUprime = new double[dn1.uprimeArray.length];
        for (int i = 0; i < newUprime.length; i++) {
            newUprime[i] = dn1.uprimeArray[i] + dn2.uprimeArray[i];
        }

        // Retornar un nuevo DualNumber con el nuevo valor u y uprimeArray
        return new DualNumber(newU, newUprime);
    }


}
