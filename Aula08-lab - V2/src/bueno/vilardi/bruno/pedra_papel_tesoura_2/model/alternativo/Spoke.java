package bueno.vilardi.bruno.pedra_papel_tesoura_2.model.alternativo;

import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.Jogada;
import bueno.vilardi.bruno.pedra_papel_tesoura_2.model.classico.*;

public class Spoke extends Jogada {

    @Override
    public Jogada[] jogadasQueVenco(Jogada jogada) {
        return new Jogada[]{new Tesoura(), new Pedra()};
    }

    @Override
    public Jogada[] jogadasQuePerco(Jogada jogada) {
        return new Jogada[]{new Papel(), new Lagarto()};
    }

    @Override
    public String toString() {
        return "Spoke";
    }
}
