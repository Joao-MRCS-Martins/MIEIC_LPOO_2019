package geometria;

public class FiguraComposta extends Figura {
    private Figura[] figuras;

    FiguraComposta(Figura [] figuras) {
        this.figuras = figuras;
        for(Figura fig: figuras)
            area += fig.getArea();
    }

    public Figura[] getFiguras() {
        return figuras;
    }

    public int count() {
        return figuras.length;
    }
}
