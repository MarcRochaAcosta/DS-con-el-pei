public interface Function {
    DualNumber evaluate(DualNumber dn);
    DualNumber evaluate(double[] x); // Para funciones de varias dimensiones
}
