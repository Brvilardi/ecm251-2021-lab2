package bueno.vilardi.bruno;

public class Sistema {
    public static void debug() {
        System.out.println("Inicializando sistema...");

        //Criação de Usuários-teste
        System.out.println("\nCriando usuários...\n");
        Usuario Bruno = new Usuario("Bruno Vilardi", "teste123", "bruno@bruno.com");
        Usuario Matheus = new Usuario("Matheus Penteriche", "1234", "matheus@matheus.com");
        Usuario Martin = new Usuario("Martin Ropke", "abcde", "martin@martin.com");
        System.out.println(Bruno);
        System.out.println(Matheus);
        System.out.println(Martin);
        System.out.println("-------------------------------------------------");

        //Criar Contas
        System.out.println("\nCriando Contas e aribuindo a usuários...\n");
        Conta contaBruno = new Conta(1000, Bruno);
        Conta contaMatheus = new Conta(250, Matheus);
        Conta contaMartin = new Conta(3000, Martin);
        System.out.println(Bruno);
        System.out.println(Matheus);
        System.out.println(Martin);
        System.out.println("-------------------------------------------------");

        //Tranferir valores
        boolean resultado;
        System.out.println("\nTestando transferencias...");

        System.out.println("\nCriando requisição1 de transferencia (Bruno gera uma operação de recebimento de 250)...");
        String requisicao1 = Transferencia.gerarString(contaBruno, 250);
        System.out.println("Requisição: " + requisicao1);

        System.out.println("\nValores iniciais:");
        System.out.println(contaBruno);
        System.out.println(contaMatheus);
        System.out.println(contaMartin);

        System.out.println("\nMatheus paga requisicao1");
        resultado = contaMatheus.transferirDinheiro(requisicao1);
        System.out.println(contaBruno);
        System.out.println(contaMatheus);
        System.out.println(contaMartin);
        System.out.println("Transferencia conluida: " + resultado);

        System.out.println("\nMartin paga requisicao1");
        resultado = contaMartin.transferirDinheiro(requisicao1);
        System.out.println(contaBruno);
        System.out.println(contaMatheus);
        System.out.println(contaMartin);
        System.out.println("Transferencia conluida: " + resultado);

        System.out.println("\nMatheus paga requisicao1");
        resultado = contaMatheus.transferirDinheiro(requisicao1);
        System.out.println(contaBruno);
        System.out.println(contaMatheus);
        System.out.println(contaMartin);
        System.out.println("Transferencia conluida: " + resultado);

        System.out.println("\nCriando requisição2 de transferencia (Matheus gera uma operação de recebimento de 1000)...");
        String requisicao2 = Transferencia.gerarString(contaMatheus, 1000);
        System.out.println("Requisição: " + requisicao2);

        System.out.println("\nMartin paga requisicao2");
        resultado = contaMartin.transferirDinheiro(requisicao2);
        System.out.println(contaBruno);
        System.out.println(contaMatheus);
        System.out.println(contaMartin);
        System.out.println("Transferencia conluida: " + resultado);
        System.out.println("------------------------------------------------");


    }

    public static void run(){


    }

    public static void mostrarMenuInicial(){

    }

}
