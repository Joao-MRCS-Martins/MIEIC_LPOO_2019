import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Comboio {
    private String nome;
    private List<Carruagem> carruagens;
    protected ServicoABordo s;
    Comboio(String nome) {
        this.nome = nome;
        carruagens = new ArrayList<>();
        s = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }
    public int getNumLugares() {
        int sum =0;
        for(Carruagem car: carruagens)
            sum += car.getNumLugares();
        return sum;
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public void addCarruagem(Carruagem c) {
        carruagens.add(c);
    }

    public List<Carruagem> getCarruagens() {
        return carruagens;
    }

    public Carruagem getCarruagemByOrder(int index) {
        return carruagens.get(index);
    }

    public void removeAllCarruagens(int capacity) {
        Iterator itr = carruagens.iterator();
        while(itr.hasNext()) {
            Carruagem car = (Carruagem)itr.next();
            if(car.getNumLugares() == capacity)
                itr.remove();
        }
    }

    public int getNumPassageiros() {
        int sum =0;
        for(Carruagem car: carruagens)
            sum += car.getNumPassageiros();
        return sum;
    }

    public int getLugaresLivres() {
        int sum =0;
        for(Carruagem car: carruagens)
            sum += car.getLugaresLivres();
        return sum;
    }

    public void addPassageiros(int i) throws PassengerCapacityExceeded {
        if(i > getLugaresLivres())
            throw new PassengerCapacityExceeded();
        int curr = i;
        for(Carruagem car: carruagens) {
            if(curr ==0)
                break;
            curr -= car.addPassageiros(curr);
        }
    }

    public void removePassageiros(int i) throws PassengerCapacityExceeded {
        if(i > getNumPassageiros())
            throw new PassengerCapacityExceeded();

        for(Carruagem car: carruagens) {
            if(i ==0)
                break;
            i = i - car.removePassageiros(i);
        }
    }

    public void removePassageiros() {
        for(Carruagem car: carruagens) {
            car.removePassageiros();
        }
    }

    public boolean equals(Object o) {
        if(carruagens.size() != ((Comboio)o).getCarruagens().size())
            return false;
        for(int i =0; i < carruagens.size(); i++) {
            if(carruagens.get(i).getNumLugares() != ((Comboio)o).getCarruagens().get(i).getNumLugares())
                return false;
        }
        return true;
    }

    public ServicoABordo getServicoABordo() {
        return s;
    }

    public void setServicoABordo(ServicoABordo s) {
        this.s = s;
    }

    public String getDescricaoServico() {
        return s.toString();
    }


    public String toString() {

        return  "Comboio " + this.nome + ", " + (carruagens.size() == 1 ? "1 carruagem, " : (carruagens.size() + " carruagens, ")) +  (getNumLugares() == 1 ? "1 lugar, " : (getNumLugares() + " lugares, "))
                + (getNumPassageiros() == 1 ? "1 passageiro" : (getNumPassageiros() + " passageiros"));
    }
}
