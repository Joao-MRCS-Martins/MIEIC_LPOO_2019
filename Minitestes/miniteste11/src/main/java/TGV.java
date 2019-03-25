public class TGV extends Comboio {


    TGV(String nome) {
        super(nome);
        s = new ServicoPrioritario();
    }

    public String toString() {

        return  "TGV " + getNome() + ", " + (getCarruagens().size() == 1 ? "1 carruagem, " : (getCarruagens().size() + " carruagens, ")) +  (getNumLugares() == 1 ? "1 lugar, " : (getNumLugares() + " lugares, "))
                + (getNumPassageiros() == 1 ? "1 passageiro" : (getNumPassageiros() + " passageiros"));
    }
}
