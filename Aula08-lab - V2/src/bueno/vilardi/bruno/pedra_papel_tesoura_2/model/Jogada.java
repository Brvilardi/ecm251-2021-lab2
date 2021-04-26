package bueno.vilardi.bruno.pedra_papel_tesoura_2.model;

import bueno.vilardi.bruno.pedra_papel_tesoura_2.enumeracao.Resultado;

public abstract class Jogada {
    public final Resultado verificarResultado(Jogada jogada) {
        if(verificarSeGanhei(jogada)){
            return Resultado.GANHOU;
        } else if(verificarSePerdi(jogada)){
            return Resultado.PERDEU;
        }
        return Resultado.EMPATOU;
    }

    final private boolean verificarSePerdi(Jogada jogada) {
        for (Jogada jogadaGanha: jogadasQuePerco(jogada)){
            if (jogada.getClass() == jogadaGanha.getClass()) {
                return true;
            }
        }
        return false;
    }

    final private boolean verificarSeGanhei(Jogada jogada) {
        for (Jogada jogadaGanha: jogadasQueVenco(jogada)){
            if (jogada.getClass() == jogadaGanha.getClass()) {
                return true;
            }
        }
        return false;
    }

    public abstract Jogada[] jogadasQueVenco(Jogada jogada);
    public abstract Jogada[] jogadasQuePerco(Jogada jogada);
}
