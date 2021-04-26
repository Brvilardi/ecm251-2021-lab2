package bueno.vilardi.bruno.pedra_papel_tesoura_2.model;

public class Jogador {
    private final String nome;
    private final boolean ehHumano;
    private Jogada jogada;

    public Jogador(String nome) {
        this.nome = nome;
        this.ehHumano = true;
    }
    public Jogador(){
        this.nome = "Rôbo";
        this.ehHumano = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isEhHumano() {
        return ehHumano;
    }

    public Jogada getJogada() {
        return jogada;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }
}
