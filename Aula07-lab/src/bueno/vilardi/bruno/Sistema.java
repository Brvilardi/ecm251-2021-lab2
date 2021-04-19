package bueno.vilardi.bruno;

import java.util.Random;
import java.util.Scanner;

public class Sistema {
    private Jogador player1, player2;
    private Scanner scanner;
    private Jogada [] jogadas = new Jogada[]{new Pedra(), new Papel(), new Tesoura()};

    public Sistema(){
        scanner = new Scanner(System.in);
        inicializarJogadores();
    }
    public void run(){
        boolean continuar = true;
        do{
            System.out.println(player1.getNome() + " vs " + player2.getNome());
            player1.setJogada(escolheJogada());
            player2.setJogada(sortearJogada());
            System.out.println("Jogada Player 1: " + player1.getJogada());
            System.out.println("Jogada Player 2: " + player2.getJogada());

            System.out.println("Resultado: " + player1.getJogada().verificarResultado(player2.getJogada()));
        }while(continuar);
    }

    private Jogada escolheJogada() {
        System.out.println("Informe sua jogada:\n 0 - Pedra\n1 - Papel\n2 - Tesoura ");
        int escolha = scanner.nextInt(); //Necessário proteger
        return jogadas[escolha];

    }

    private Jogada sortearJogada() {
        return jogadas[new Random().nextInt(jogadas.length)];
    }

    private void inicializarJogadores() {
        System.out.println("Informe um nome para o Jogador 1: ");
        String nome = scanner.next();
        this.player1 = new Jogador(nome);
        this.player2 = new Jogador();
    }
}
