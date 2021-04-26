package bueno.vilardi.bruno.pedra_papel_tesoura.model.alternativo;

import bueno.vilardi.bruno.pedra_papel_tesoura.model.Jogada;
import bueno.vilardi.bruno.pedra_papel_tesoura.model.classico.Papel;
import bueno.vilardi.bruno.pedra_papel_tesoura.model.classico.Pedra;
import bueno.vilardi.bruno.pedra_papel_tesoura.model.classico.Tesoura;

public class Lagarto extends Jogada {
    @Override
    public boolean verificarSeGanhei(Jogada jogada) {
        return (jogada instanceof Spoke) || (jogada instanceof Papel);
    }

    @Override
    public boolean verificarSePerdi(Jogada jogada) {
        return (jogada instanceof Tesoura) || (jogada instanceof Pedra);
    }

    @Override
    public String toString() {
        return "Spoke";
    }
}
