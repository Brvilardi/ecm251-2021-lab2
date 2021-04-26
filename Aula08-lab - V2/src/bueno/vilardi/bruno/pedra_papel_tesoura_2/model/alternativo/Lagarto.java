package bueno.vilardi.bruno.pedra_papel_tesoura_2.model.alternativo;

import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.Jogada;
import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.classico.Papel;
import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.classico.Pedra;
import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.classico.Tesoura;

public class Lagarto extends Jogada {
    @Override
    public Jogada[] jogadasQueVenco(Jogada jogada) {
        return new Jogada[]{new Papel(), new Spoke()};
    }

    @Override
    public Jogada[] jogadasQuePerco(Jogada jogada) {
        return new Jogada[]{new Pedra(), new Tesoura()};
    }

    @Override
    public String toString() {
        return "Lagarto";
    }
}
