package bueno.vilardi.bruno;

/*TO DO:

-Desenhar menu com opcoes para modo administardor, login de usuario e desligar
- cada entrada do menu é possivel dar logout

-administrador terá uma senha = "teste123"

-administrador pode criar usuarios, contas e fazer transferencias de qlq conta de qlq conta

-usuario pode criar contas e fazer transferencias(só pode criar requests para suas contas e só pode pagar usando suas contas)


 */


import java.util.Scanner;

public class Sistema {
    public static int menu = 0; //seleciona o menu inicial
    public static Usuario usuarioLogado = null; //inicia usuario como ninguem

    //Roda o programa com ações definidas para testar o funcionamento
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

    //Roda o programa principal
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        while(Sistema.menu != 3){
            switch(Sistema.menu){
                case 0:
                    mostrarMenuInicial();
                    break;
                case 1:
                    if (Sistema.usuarioLogado == null && Sistema.usuarioLogado.nomeComleto != "admin"){ //Verifica se usuário está logado no sistema
                        logarUsuario(scanner);
                    }
                    mostrarMenuAdministrador();
                case 2:
                    if (Sistema.usuarioLogado == null){ //Verifica se usuário está logado no sistema
                        logarUsuario(scanner);
                    }
                    mostrarMenuUsuario();
                default:
                    System.out.println("Tecla errada ou opção ainda não desenvolvida");
            }
            System.out.println("Digite uma opção: ");
            Sistema.menu = scanner.nextInt();
        }


    }

    private static void mostrarMenuUsuario() {
    }

    private static void logarUsuario(Scanner scanner){
        System.out.println("Por favor, insira suas credenciais:");
        System.out.println("Nome:");
        String nomeUsuario = scanner.next();
        if (nomeUsuario == "0"){
            Sistema.menu = 0;
            return;
        }
        System.out.println("Senha: ");
        String senha = scanner.next();
        if (Usuario.autenticarUsuario("nome", "senha")){
            System.out.println("Usuario " + Sistema.usuarioLogado.nomeComleto + " logado com sucesso!");
        }
    }

    private static void mostrarMenuAdministrador() {


    }

    //Desenha o menu inicial
    public static void mostrarMenuInicial(){
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("1 - Login como administrador");
        System.out.println("2 - Login como usuário");
        System.out.println("3 - Desligar");
    }



}
