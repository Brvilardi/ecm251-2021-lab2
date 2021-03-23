package bueno.vilardi.bruno;

import java.util.HashMap;
import java.util.Map;

public class Transferencia {

    public static String gerarString(Conta recebedora, double valor){ //Gera string especificada para uso no QR Code
        //Dados: "idConta;nomeUsuario;valor;numeroAleatorio"
        return "" + recebedora.id + ";" + recebedora.proprietario.nomeComleto + ";"+ valor + ";" + AuxiliarFunctions.getRandomNumberInRange(1000, 9999);
    }

    public static boolean realizarTransferencia(Conta pagadora, Conta recebedora, double valor){ //Tenta realizar a tranferencia entre as contas especificadas - retorna se deu certo
        String string = gerarString(recebedora, valor);
        return pagadora.transferirDinheiro(string);
    }
}