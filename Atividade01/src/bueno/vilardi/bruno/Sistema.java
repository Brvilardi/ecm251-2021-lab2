package bueno.vilardi.bruno;

public class Sistema {
    public static void run() {
        System.out.println("Inicializando sistema...");

        //Criação de Usuários-teste
        Usuario Bruno = new Usuario("Bruno Vilardi", "teste123", "bruno@bruno.com");

        //Criar Contas
        Conta conta1 = new Conta(123,100.0, Bruno);
        Conta conta2 = new Conta(345,160.0, Bruno);

        System.out.println(Bruno);
    }


}
