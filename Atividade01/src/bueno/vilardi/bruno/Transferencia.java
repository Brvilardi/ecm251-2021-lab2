package bueno.vilardi.bruno;

import java.util.HashMap;
import java.util.Map;

public class Transferencia {

    public static String gerarString(Conta recebedora, double valor){ //Gera string especificada para uso no QR Code
        //Dados: "idConta;nomeUsuario;valor;numeroAleatorio"
        return "" + recebedora.id + ";" + recebedora.getNomeProprietario() + ";"+ valor + ";" + AuxiliarFunctions.getRandomNumberInRange(1000, 9999);
    }

    public static boolean realizarTransferencia(Conta pagadora, String requisicao){ //Tenta realizar a tranferencia entre a conta pagadora e a requisicao - retorna se deu certo
        return pagadora.transferirDinheiro(requisicao);
    }
}