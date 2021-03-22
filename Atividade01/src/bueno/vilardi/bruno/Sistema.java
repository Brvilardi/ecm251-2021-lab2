package bueno.vilardi.bruno;

public class Sistema {
    public static void debug() {
        System.out.println("Inicializando sistema...");

        //Criação de Usuários-teste
        System.out.println("Criando usuários...");
        Usuario Bruno = new Usuario("Bruno Vilardi", "teste123", "bruno@bruno.com");
        System.out.println(Bruno);

        //Criar Contas
        System.out.println("Criando Contas e aribuindo a usuários...");
        Conta conta1 = new Conta(100.0, Bruno);
        Conta conta2 = new Conta(160.0, Bruno);
        System.out.println(Bruno);


    }


}
