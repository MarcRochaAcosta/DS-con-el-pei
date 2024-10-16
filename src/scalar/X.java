package scalar;

public class X implements Function {
    @Override
    public DualNumber evaluate(DualNumber dn) {
        return dn; // Devuelve el mismo valor del número dual
    }
}