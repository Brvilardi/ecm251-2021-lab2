package bueno.vilardi.bruno.pedra_papel_tesoura_2.model.classico;

import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.Jogada;
import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.alternativo.*;

public class Papel extends Jogada {

    @Override
    public Jogada[] jogadasQueVenco(Jogada jogada) {
        return new Jogada[]{new Pedra(), new Spoke()};
    }

    @Override
    public Jogada[] jogadasQuePerco(Jogada jogada) {
        return new Jogada[]{new Tesoura(),new Lagarto()};
    }

    @Override
    public String toString() {
        return "Papel";
    }
}
