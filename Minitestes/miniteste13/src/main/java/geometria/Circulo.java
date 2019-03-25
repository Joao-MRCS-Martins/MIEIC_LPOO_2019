package geometria;

public class Circulo extends Figura{
    private Ponto centro;
    private int raio;

    Circulo(Ponto c,int radius) throws IllegalArgumentException{
        centro = c;
        if(radius <=0)
            throw new IllegalArgumentException();
        raio = radius;
        area = Math.PI* Math.pow(radius,2);
        perimetro = 2* radius * Math.PI;
    }

    public Ponto getCentro() {
        return centro;
    }

    public int getRaio() {
        return raio;
    }
}
