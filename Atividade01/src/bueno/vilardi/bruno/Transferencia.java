package bueno.vilardi.bruno;

public class Transferencia {

    public static String gerarString(Conta recebedora, double valor){
        return "" + recebedora.id + ";" + valor + ";" + AuxiliarFunctions.getRandomNumberInRange(1000, 9999);
}

    public static boolean realizarTransferencia(Conta recebedora, Conta pagadora, double valor){
        String string = gerarString(recebedora, valor);

    }
}