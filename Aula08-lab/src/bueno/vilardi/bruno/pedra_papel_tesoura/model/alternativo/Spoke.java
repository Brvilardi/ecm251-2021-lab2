package bueno.vilardi.bruno.pedra_papel_tesoura.model.alternativo;

import bueno.vilardi.bruno.pedra_papel_tesoura.model.Jogada;
import bueno.vilardi.bruno.pedra_papel_tesoura.model.classico.*;

public class Spoke extends Jogada {


    @Override
    public boolean verificarSeGanhei(Jogada jogada) {
        return (jogada instanceof Pedra) || (jogada instanceof Tesoura);
    }

    @Override
    public boolean verificarSePerdi(Jogada jogada) {
        return (jogada instanceof Papel) || (jogada instanceof Lagarto);
    }

    @Override
    public String toString() {
        return "Spoke";
    }
}
