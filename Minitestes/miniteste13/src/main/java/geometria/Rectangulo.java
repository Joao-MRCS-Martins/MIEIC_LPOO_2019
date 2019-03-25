package geometria;

public class Rectangulo extends Figura {
    private Ponto p1;
    private Ponto p2;

    Rectangulo(int x1,int y1,int x2, int y2) {
        p1 = new Ponto(x1,y1);
        p2 = new Ponto(x2,y2);
        area = (x2-x1)*(y2-y1);
        perimetro = 2*(x2-x1)+2*(y2-y1);
    }
}
