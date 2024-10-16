public class DualNumber {
    public double u;
    public double uprime;
    public double[] uprimeArray; // Para el caso multidimensional

    public DualNumber(double u, double uprime) {
        this.u = u;
        this.uprime = uprime;
    }

    public DualNumber(double u, double[] uprimeArray) {
        this.u = u;
        this.uprimeArray = uprimeArray;
    }

    public double getU() {
        return  u;
    }
    public double getUprime() {
        return uprime;
    }

    public double[] getUprimeArray() {
        return uprimeArray;
    }
}