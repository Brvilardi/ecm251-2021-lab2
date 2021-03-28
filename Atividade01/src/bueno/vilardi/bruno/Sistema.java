package bueno.vilardi.bruno;

/*TO DO:


 */


import java.util.Scanner;

public class Sistema {
    public static int menuGeral = 0; //seleciona o menuGeral inicial
    public static int menuEspecifico = 0; //seleciona o menuEspecifico inicial
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

        //Final dos testes
         System.out.println("\n\nResultado dos testes: ");
         System.out.println("Usuario 1 - saldo = 1500,00 ... " + contaBruno.saldoIgual(1500));
         System.out.println("Usuario 2 - saldo = 1000,00 ... " + contaMatheus.saldoIgual(1000));
         System.out.println("Usuario 3 - saldo = 1750,00 ... " + contaMartin.saldoIgual(1750));

    }

    //Roda o programa principal
    public static void run(){
        System.out.println("Inicializando sistema...");
        //Cria usuário administrador
        new Usuario("admin", "senha forte", "admin@admin.com");

        //Cria instância scanner para entrada do usuario via console
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); //scanner vai pegar strings com espaço

        //Começa o laço de repetição do programa
        while(Sistema.menuGeral != 3){ //Menu = 3 é para desligar o sistema
            switch(Sistema.menuGeral){
                case 0: //Menu não selecionado
                    mostrarMenuInicial();
                    System.out.println("Digite uma opção: ");
                    Sistema.menuGeral = scanner.nextInt();
                    break;
                case 1:
                    //System.out.println(Usuario.getUsuarios());
                    if (Sistema.usuarioLogado == null || !Sistema.usuarioLogado.nomeComleto.equals("admin")){ //Verifica se usuário está logado no sistema ou se usuario não é admin
                        Sistema.usuarioLogado = null;
                        logarUsuario(scanner);
                    } else {
                        mostrarMenuAdministrador(scanner);
                        analisarMenuAdministrador(scanner);
                    }
                    break;
                case 2:
                    if (Sistema.usuarioLogado == null){ //Verifica se usuário está logado no sistema
                        logarUsuario(scanner);
                    } else {
                        mostrarMenuUsuario(scanner);
                        analisarMenuUsuario(scanner);
                    }
                    break;
                default:
                    System.out.println("Tecla errada ou opção ainda não desenvolvida");
                    Sistema.menuGeral = 0;
                    break;
            }
        }
    }

    //Desenha o menuGeral inicial
    public static void mostrarMenuInicial(){
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("1 - Login como administrador");
        System.out.println("2 - Login como usuário");
        System.out.println("3 - Desligar");
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        System.out.println("Por favor, escolha uma opção (administrador):");
        System.out.println("1 - Criar usuário");
        System.out.println("2 - Criar conta");
        System.out.println("3 - Exibir usuários");
        System.out.println("4 - Exibir contas");
        System.out.println("5 - Logout");
        Sistema.menuEspecifico = scanner.nextInt();
    }

    private static void analisarMenuAdministrador(Scanner scanner) {
         switch (Sistema.menuEspecifico){
             case 1: //Criar usuário
                 //Entrada de dados do novo usuário
                 System.out.println("\nPara criar um novo usuário, por favor, informe...");
                 System.out.println("Nome completo:");
                 String nomeNovoUsuario = scanner.next();
                 System.out.println("Senha:");
                 String senha = scanner.next();
                 System.out.println("email:");
                 String email = scanner.next();

                 //Criação do novo usuario
                 new Usuario(nomeNovoUsuario, senha, email);

                 break;
             case 2: //Criar conta
                 //Entrada de dados da conta
                 System.out.println("Para criar uma nova conta, por favor, informe...");
                 System.out.println("Nome do usuario da conta: ");
                 String nomeUsuarioConta = scanner.next();
                 System.out.println("Confirme o nome: ");
                 String nomeConfirma = scanner.next();
                 if (!nomeUsuarioConta.equals(nomeConfirma)){ //Verifica se o nome de usuário foi digitado corretamente
                     System.out.println("Os nomes não batem...");
                     break;
                 }
                 if (Usuario.naoExisteUsuario(nomeUsuarioConta)){
                     System.out.println("Usuario não existe...");
                     break;
                 }
                 System.out.println("Saldo inicial: ");
                 double saldoInicialConta = scanner.nextDouble();

                 //Cria a conta
                 new Conta(saldoInicialConta, Usuario.getUsuarioPeloNome(nomeUsuarioConta));
                 break;
             case 3: //Exibir usuários
                 Usuario.exibirUsuarios(Sistema.usuarioLogado);
                 break;
             case 4: //Exibir contas
                 Conta.exibirContas(Sistema.usuarioLogado);
                 break;
             case 5: //Logout
                 Sistema.logout();
                 break;
         }
    }

    private static void mostrarMenuUsuario(Scanner scanner) {
        System.out.println("Por favor, escolha uma opção (usuario):");
        System.out.println("1 - Exibir minhas contas");
        System.out.println("2 - Criar pedido de transferencia");
        System.out.println("3 - Realizar tranferência");
        System.out.println("4 - Logout");
        Sistema.menuEspecifico = scanner.nextInt();
    }

    private static void analisarMenuUsuario(Scanner scanner) {
         switch(Sistema.menuEspecifico){
             case 1: //Exibir contas
                 System.out.println(Usuario.getContas(Sistema.usuarioLogado));
                 break;
             case 2: //Criar pedido transferencia
                 //Mostra a lista de contas do usuário e pergunta qual é a desejada para a transferencia
                 System.out.println("Suas contas disponíveis:");
                 System.out.println(Usuario.getContas(Sistema.usuarioLogado));
                 System.out.println("\nPor favor, digite o id da conta desejada:");
                 int idContaRecebedora = scanner.nextInt();

                 //Verifica se usuário possui a conta informada
                 if(!Sistema.usuarioLogado.possuiConta(idContaRecebedora)){
                     System.out.println("Usuario " + Sistema.usuarioLogado.nomeComleto + " não possui conta com id " + idContaRecebedora);
                     break;
                 }

                 //Pede o valor do pedido de transferencia
                 System.out.println("Para criar uma requisição de transferencia, por favor, informe...");
                 System.out.println("Valor: ");
                 double valorPedidoTransferencia = scanner.nextDouble();

                 //Cria o pedido de transferencia com todas as especificações
                 String novoPedidoTransferencia = Transferencia.gerarString(Sistema.usuarioLogado.getContaPeloId(idContaRecebedora), valorPedidoTransferencia);
                 System.out.println("String para pagamento: " + novoPedidoTransferencia);
                 break;
             case 3: //Realizar transferencia
                 //Pede a string da transferencia
                 System.out.println("Para realizar a transferência, por favor, informe...");
                 System.out.println("String do pedido de transferência: ");
                 String pedidoTranferencia = scanner.next();

                 //Valida o pedido
                 if (!Transferencia.validarString(pedidoTranferencia)){
                     System.out.println("Pedido inválido, por favor, verifique se o pedido de transferenca está no padrao <id>;<nome>;<valor>;<numeroAleatorio>");
                     break;
                 }

                 //Mostra a lista de contas do usuário e pergunta qual é a desejada para sair a transferencia
                 System.out.println("Suas contas disponíveis:");
                 System.out.println(Usuario.getContas(Sistema.usuarioLogado));
                 System.out.println("\nPor favor, digite o id da conta desejada para realizar o pagamento:");
                 int idContaPagadora = scanner.nextInt();

                 //Verifica se usuário possui a conta informada
                 if(!Sistema.usuarioLogado.possuiConta(idContaPagadora)){
                     System.out.println("Usuario " + Sistema.usuarioLogado.nomeComleto + " não possui conta com id " + idContaPagadora);
                     break;
                 }

                 if (Transferencia.realizarTransferencia(Sistema.usuarioLogado.getContaPeloId(idContaPagadora), pedidoTranferencia)){
                     System.out.println("Transferencia realizada com sucesso!");
                 } else{
                     System.out.println("Não foi possível realizar a transferencia");
                 }

                 break;
             case 4: //logout
                 logout();
                 break;

         }
    }

    private static void logarUsuario(Scanner scanner){
        System.out.println("Por favor, insira suas credenciais.");
        System.out.println("Nome:");
        String nomeUsuario = scanner.next(); //recebe toda a linha, contando os espaços
        if (nomeUsuario.equals("")){
            System.out.println("Nome de usuário não digitado, retornando ao menuGeral inicial");
            Sistema.menuGeral = 0;
            return;
        }
        System.out.println("Senha: ");
        String senha = scanner.next();
        if (senha.equals("")){
            System.out.println("Senha não digitada, retornando ao menuGeral inicial");
            Sistema.menuGeral = 0;
            return;
        }
        if (Usuario.autenticarUsuario(nomeUsuario, senha) && nomeUsuario.equals("admin")){
            System.out.println("Usuario " + Sistema.usuarioLogado.nomeComleto + " logado com sucesso!");
        } else {
            System.out.println("Credenciais incorretas, tente novamente (ou pressione 'enter' para voltar ou menu principal)...\n");
        }
    }

    private static void logout() {
        String nome = Sistema.usuarioLogado.nomeComleto;
        Sistema.usuarioLogado = null;
        Sistema.menuGeral = 0;
        Sistema.menuEspecifico = 0;
        System.out.println("Usuário " + nome + " deslogado com sucesso...\n\n");
    }




}
