package bueno.vilardi.bruno;

import java.util.Random;

public class Basico03 {
    public static void main(String[] args) {
        //Estruturas de repeticao
        int limite = 10;
        int count;

        for(count=0; count < limite; count++){
            System.out.println("Contador: " + count);
        }

        //Cria um objeto que sorteia coisas
        Random sorteador = new Random();
        int numero = sorteador.nextInt(1000);
        System.out.println("Numero sorteado: " + numero);

        //Quebrar senha
        int senha = 123456;
        int tentativas = 0, chute;
        chute = sorteador.nextInt(999999);
        while (chute != senha){
            tentativas ++;
            System.out.println("tentativa n " + tentativas);
            System.out.println("Anda não quebrou: " + chute);
            chute = sorteador.nextInt(999999);
        }
        System.out.println("Parabens! Quase um cracker!");
        System.out.println("Levou apenas: " + tentativas);

    }


}
