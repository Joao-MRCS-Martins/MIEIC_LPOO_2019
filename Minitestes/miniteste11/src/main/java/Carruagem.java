public class Carruagem {
    private int numLugares;
    private int numPassageiros;


    Carruagem(int lug) {
        numLugares = lug;
        numPassageiros = 0;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public int getLugaresLivres() {
        return numLugares - numPassageiros;
    }

    public int addPassageiros(int i) {
        if(i > getLugaresLivres()) {
            int before = numPassageiros;
            numPassageiros += getLugaresLivres();
            return numPassageiros - before;
        }
        else {
            numPassageiros += i;
            return i;
        }
    }

    public int removePassageiros(int i) {
        if(i > getNumPassageiros()) {
            numPassageiros -= getNumPassageiros();
            return getNumPassageiros();
        }
        else {
            numPassageiros -= i;
            return i;
        }
    }

    public void removePassageiros() {
        numPassageiros -= getNumPassageiros();
    }
}
