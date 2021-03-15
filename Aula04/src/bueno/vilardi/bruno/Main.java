package bueno.vilardi.bruno;

public class Main {

    public static void main(String[] args) {
	    //Cria um objeto do tipo conta
        Conta c1; //C1 sabe guardar objeto do tipo conta

        //Instancia um objeto conta
        c1 = new Conta();

        c1.depositar(300);
        c1.sacar(250);

    }
}
