package scalar;

public class Subscript implements Function {
    private Function base;
    private int subscript;

    public Subscript(Function base, int subscript) {
        this.base = base;
        this.subscript = subscript;
    }

    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber baseValue = base.evaluate(dn);
        // Lógica para manejar subíndices. Esto es un ejemplo y puede variar según tus necesidades.
        return new DualNumber(baseValue.getU(), baseValue.getUprime()); // Implementar lógica específica según sea necesario
    }
}