package bueno.vilardi.bruno.pedra_papel_tesoura.model.classico;

import bueno.vilardi.bruno.pedra_papel_tesoura.model.Jogada;

public class Tesoura extends Jogada {

    @Override
    public boolean verificarSeGanhei(Jogada jogada) {
        return jogada instanceof Papel;
    }

    @Override
    public boolean verificarSePerdi(Jogada jogada) {
        return jogada instanceof Pedra;
    }

    @Override
    public String toString() {
        return "Tesoura";
    }
}
