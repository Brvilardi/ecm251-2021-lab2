package bueno.vilardi.bruno.pedra_papel_tesoura.model.classico;

import bueno.vilardi.bruno.pedra_papel_tesoura.model.Jogada;

public class Papel extends Jogada {

    @Override
    public boolean verificarSeGanhei(Jogada jogada) {
        return jogada instanceof Pedra;
    }

    @Override
    public boolean verificarSePerdi(Jogada jogada) {
        return jogada instanceof Tesoura;
    }

    @Override
    public String toString() {
        return "Papel";
    }
}
