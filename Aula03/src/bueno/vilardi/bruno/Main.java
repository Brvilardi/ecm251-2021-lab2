package bueno.vilardi.bruno;

public class Main {

    public static void main(String[] args) {
	    //Cria um objeto do tipo conta
        Conta c1; //C1 sabe guardar objeto do tipo conta

        //Instancia um objeto conta
        c1 = new Conta();

        //Pede para a conta exibir o saldo
        c1.visualizarSaldo();

        //Modificar o saldo
        c1.saldo = 100;
        c1.visualizarSaldo();

        //Criar novo objeto do tipo conta
        Conta c2 = new Conta();

        c2.saldo = 123;

        c1.depositar(300);
        c2.depositar(100);

        c1.visualizarSaldo();
        c2.visualizarSaldo();


//        if(c1.sacar(100)){
//            System.out.println("Sacou!");
//        } else{
//            System.out.println("não sacou!");
//        }


        if(c1.transferirDinheiro(c2,2500)){
            System.out.println("Tansferencia realizada com sucesso");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        System.out.println("Nome do cliente " + c1.cliente.nome);

        System.out.println("c1: " + c1);
    }
}
