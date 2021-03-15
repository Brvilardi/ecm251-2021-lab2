package bueno.vilardi.bruno;

import java.util.Scanner;

public class Sistema {

    private boolean executarSistema;
    private Scanner scanner;
    private Conta conta;

    public Sistema() { //Construtor
        this.executarSistema = true;
        this.scanner = new Scanner(System.in); //Deixa o scanner ler a entrada do teclado
        this .conta = new Conta("Mario",1945,1234 );
    }

    public void executar(){
        int opcao;
        while(executarSistema) {
            exibirMenu();
            opcao = scanner.nextInt();
            avaliarOpcao(opcao);
        }
    }

    private void avaliarOpcao(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Obrigado por escolher o MauaBank");
                this.executarSistema = false;
                break;
            case 1:
                System.out.println("Saldo Atual: R$" + this.conta.getSaldo());
                break;
            case 2:
                System.out.println("Qual a quantida de dinheiro?");
                double quantiaParaSacar = scanner.nextDouble();
                if(this.conta.sacar(quantiaParaSacar)){
                    System.out.println("Operação realizado com sucesso");
                } else {
                    System.out.println("Não foi possível realizar a operação");
                }
                break;
            case 3:
                System.out.println("Qual a quantida de dinheiro?");
                double quantiaParaDepositar = scanner.nextDouble();
                this.conta.depositar(quantiaParaDepositar);
                System.out.println("Operação realizada com sucesso!");
                break;
            case 5:
                System.out.println("Nome da Conta:");
                String nome = scanner.next();
                System.out.println("Valor da conta:");
                double valorDaConta = scanner.nextDouble();
                System.out.println("Juros da conta:");
                double jurosDaConta = scanner.nextDouble();
                System.out.println("Informe a data de vencimento (ano-mes-dia)?");
                String dataVencimentoTitulo = scanner.next();
                Titulo titulo = new Titulo(valorDaConta,nome,dataVencimentoTitulo, jurosDaConta);
                if(this.conta.sacar(titulo.totalParaPagar())){
                    System.out.println("Operação Realizada com Sucesso!");
                } else {
                    System.out.println("Algo de errado aconteceu!");
                }

            default:
                System.out.println("Essa funcionalidade ainda não foi implementada");
        }
    }

    private void exibirMenu() {
        System.out.println("Bem Vindo ao MauaBank");
        System.out.println("1 - Visualizar Saldo");
        System.out.println("2 - Sacar Dinheiro");
        System.out.println("3 - Depositar Dinheiro");
        System.out.println("4 - Transferir Dinheiro");
        System.out.println("5 - Pagar Conta (Título)");
        System.out.println("0 - Encerrar");

    }


}
