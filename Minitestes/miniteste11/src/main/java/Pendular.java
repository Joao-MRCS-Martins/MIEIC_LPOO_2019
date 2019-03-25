public class Pendular extends Comboio {

    Pendular(String nome) {
        super(nome);
        s = new ServicoSemEnjoos();
    }

    public String toString() {

        return  "Pendular " + getNome() + ", " + (getCarruagens().size() == 1 ? "1 carruagem, " : (getCarruagens().size() + " carruagens, ")) +  (getNumLugares() == 1 ? "1 lugar, " : (getNumLugares() + " lugares, "))
                + (getNumPassageiros() == 1 ? "1 passageiro" : (getNumPassageiros() + " passageiros"));
    }
}
