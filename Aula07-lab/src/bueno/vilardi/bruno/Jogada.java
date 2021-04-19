package bueno.vilardi.bruno;

public class Jogada {
    public Resultado verificarResultado(Jogada jogada) {
        if(verificarSeGanhei(jogada)){
            return Resultado.GANHOU;
        } else if(verificarSePerdi(jogada)){
            return Resultado.PERDEU;
        }
        return Resultado.EMPATOU;
    }

    public boolean verificarSeGanhei(Jogada jogada){
        return false;
    }
    public boolean verificarSePerdi(Jogada jogada){
        return false;
    }
}
