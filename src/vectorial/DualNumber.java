package vectorial;

import java.util.Arrays;

public class DualNumber {
    public double u;            // Valor de la función
    public double[] uprimeArray; // Derivadas parciales

    public DualNumber(double u, double[] uprimeArray) {
        this.u = u;
        this.uprimeArray = uprimeArray != null ? uprimeArray : new double[0];
    }

    public double getU() {
        return u;
    }

    public double[] getUprimeArray() {
        return uprimeArray;
    }

    // Suma de dos DualNumbers
    public DualNumber add(DualNumber other) {
        double[] newUprimeArray = new double[uprimeArray.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            newUprimeArray[i] = this.uprimeArray[i] + other.uprimeArray[i];
        }
        return new DualNumber(this.u + other.u, newUprimeArray);
    }

    // Resta de dos DualNumbers
    public DualNumber subtract(DualNumber other) {
        double[] newUprimeArray = new double[uprimeArray.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            newUprimeArray[i] = this.uprimeArray[i] - other.uprimeArray[i];
        }
        return new DualNumber(this.u - other.u, newUprimeArray);
    }

    // Multiplicación de dos DualNumbers
    public DualNumber multiply(DualNumber other) {
        double[] newUprimeArray = new double[uprimeArray.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            newUprimeArray[i] = this.uprimeArray[i] * other.u + this.u * other.uprimeArray[i];
        }
        return new DualNumber(this.u * other.u, newUprimeArray);
    }

    // División de dos DualNumbers
    public DualNumber divide(DualNumber other) {
        double[] newUprimeArray = new double[uprimeArray.length];
        for (int i = 0; i < uprimeArray.length; i++) {
            newUprimeArray[i] = (this.uprimeArray[i] * other.u - this.u * other.uprimeArray[i]) / (other.u * other.u);
        }
        return new DualNumber(this.u / other.u, newUprimeArray);
    }

    @Override
    public String toString() {
        return "DualNumber(u = " + u + ", uprimeArray = " + Arrays.toString(uprimeArray) + ")";
    }
}
