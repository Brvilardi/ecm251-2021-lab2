package bueno.vilardi.bruno;

public class Sistema {
    public static void debug() {
        System.out.println("Inicializando sistema...");

        //Criação de Usuários-teste
        System.out.println("\nCriando usuários...\n");
        Usuario Bruno = new Usuario("Bruno Vilardi", "teste123", "bruno@bruno.com");
        Usuario Matheus = new Usuario("Matheus Penteriche", "1234", "matheus@matheus.com");
        System.out.println(Bruno);
        System.out.println(Matheus);

        //Criar Contas
        System.out.println("\nCriando Contas e aribuindo a usuários...\n");
        Conta contaBruno1 = new Conta(100.0, Bruno);
        Conta contaBruno2 = new Conta(160.0, Bruno);

        Conta contaMatheus1 = new Conta(200, Matheus);
        System.out.println(Bruno);
        System.out.println(Matheus);

        //Adicionar valores em conta
        System.out.println("\nAdicionando valores nas contas...\n");
        contaBruno1.adicionarDinheiro(50);
        contaBruno2.adicionarDinheiro(100);
        contaMatheus1.adicionarDinheiro(200);
        System.out.println(Bruno);
        System.out.println(Matheus);

        //Retirar valores em conta
        System.out.println("\nRetirando valores nas contas...\n");
        contaBruno1.retirarDinheiro(50/2);
        contaBruno2.retirarDinheiro(100/2);
        contaMatheus1.retirarDinheiro(200/2);
        System.out.println(Bruno);
        System.out.println(Matheus);

        //Tranferir valores em conta
        System.out.println("\nTrasferindo 100 de contaBruno1 p/ contaBruno2...\n");
        Transferencia.realizarTransferencia(contaBruno1, contaBruno2, 100);
        System.out.println(Bruno);
        System.out.println(Matheus);

        //Testando GetConta
        System.out.println("\nMetodo Conta.getConta(id)...\n");
        System.out.println(Conta.getConta(1));
        System.out.println(Conta.getConta(2));
        System.out.println(Conta.getConta(3));
        System.out.println(Conta.getConta(4));

    }


}
