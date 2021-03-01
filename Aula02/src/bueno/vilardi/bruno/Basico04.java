package bueno.vilardi.bruno;

import java.util.Scanner;

public class Basico04 {
    public static void main(String[] args) {
        //Interagir com o terminal - entrada de dados do usuario
        /*
        Dados:
        Capricórnio - Janeiro
        Aquário - Fevereiro
        Peixes - Março
        Áries - Abril
        Touro - Maio
        Gêmeos - Junho
        Câncer - Julho
        Leão - Agosto
        Virgem - Setembro
        Libra - Outubro
        Escorpião - Novembro
        Sagitário - Dezembro
         */

        String nome, mes, cavaleiro;
        System.out.println("Informe seu nome: ");

        //Ler dados do teclado (console)
        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();
        System.out.println("Informe o mês de seu aniversário: ");
        mes = scanner.nextLine();

        System.out.println("Nome: " + nome + " / Mes: " + mes);

        cavaleiro = achaCavaleiro(mes); //Criar uma funcao
        System.out.println("Cavaleiro: " + cavaleiro);


    }

    private static String achaCavaleiro(String mes) {
            if (mes.equals("janeiro")) return "Shura";
            else if (mes.equals("fevereiro")) return "Kamus";
            else if (mes.equals("março")) return "Albafica";
            else if (mes.equals("abril")) return "Mu";
            else if (mes.equals("maio")) return "Aldebaram";
            else if (mes.equals("junho")) return "Saga/Kanon";
            else if (mes.equals("julho")) return "Mascara da morte";
            else if (mes.equals("agosto")) return "Aioria";
            else if (mes.equals("setembro")) return "Shaka";
            else if (mes.equals("outubro")) return "Mestre Anciào";
            else if (mes.equals("novembro")) return "Miro";
            else if (mes.equals("dezembro")) return "Aioros";
            else return "Serpentário";

    }
}
