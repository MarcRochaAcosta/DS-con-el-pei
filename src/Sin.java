public class Sin implements Function {
    private Function func;

    public Sin(Function func) {
        this.func = func;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = func.evaluate(dn);
        return new DualNumber(Math.sin(dn1.u), Math.cos(dn1.u) * dn1.uprime);
    }

    @Override
    public DualNumber evaluate(double[] x) {
        DualNumber dn1 = func.evaluate(x);

        // Validación adicional
        if (dn1.uprimeArray == null) {
            throw new NullPointerException("Sin: uprimeArray es null.");
        }

        double[] uprimeArray = new double[x.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            uprimeArray[i] = Math.cos(dn1.u) * dn1.uprimeArray[i];
        }
        return new DualNumber(Math.sin(dn1.u), uprimeArray);
    }
}
