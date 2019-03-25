package geometria;

public class Ponto implements Comparable<Ponto> {
    private int X;
    private int Y;

    Ponto(int x, int y) {
        X = x;
        Y = y;
    }
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        return "(" + X+ ", "+Y+")";
    }

    public boolean equals(Object o) {
        return X == ((Ponto)o).getX() && Y == ((Ponto)o).getY();
    }

    public int compareTo(Ponto p) {
        if (X < p.getX())
            return -1;
        else if(X>p.getX())
            return 1;
        else if(Y<p.getY())
            return -1;
        else if(Y> p.getY())
            return 1;
        else
            return 0;
    }
}
