package bueno.vilardi.bruno.pedra_papel_tesoura.model;

import bueno.vilardi.bruno.pedra_papel_tesoura.enumeracao.Resultado;

public abstract class Jogada {
    public final Resultado verificarResultado(Jogada jogada) {
        if(verificarSeGanhei(jogada)){
            return Resultado.GANHOU;
        } else if(verificarSePerdi(jogada)){
            return Resultado.PERDEU;
        }
        return Resultado.EMPATOU;
    }

    public abstract boolean verificarSeGanhei(Jogada jogada);
    public abstract boolean verificarSePerdi(Jogada jogada);
}
