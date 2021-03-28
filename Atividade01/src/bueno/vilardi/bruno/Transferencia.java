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

    public static boolean validarString(String string){
        //Verifica o número de ';'
        int numeroDeSeparador = string.length() - string.replace(";", "").length(); //Char total = char sem ';' = numero de ';'
        if (numeroDeSeparador != 3){ //Não tem o número correto de ';', logo é inválido
            System.out.println("Erro com numero de ';' - esperado: 3 / recebido: " + numeroDeSeparador);
            return false;
        }

        String[] dados = string.split(";"); //Dados: "idConta;nomeUsuario;valor;numeroAleatorio"

        //Verifica se os tipos de dado são coerentes
        int idContaDestino;
        try {
            idContaDestino = Integer.parseInt(dados[0]);
        } catch(Exception e) { //id da conta não pode ser convertido para int
            System.out.println("Erro com conversão do id da conta");
            return false;
        }

        try {
            double valor = Double.parseDouble(dados[2]);
        } catch(Exception e) { //valor não pode ser convertido para double
            System.out.println("Erro com conversão do valor da transferencia");
            return false;
        }

        int idTransacao;
        try {
            idTransacao = Integer.parseInt(dados[3]);
        } catch(Exception e) { //id da transação não pode ser convertido para int
            System.out.println("Erro com conversão do id da transferencia");
            return false;
        }

        String nomeUsuarioContaDestino = dados[1];

        //Verifica se existe o usuario recebedor pussui a conta destino
        if (!Conta.comparaIdProprietario(idContaDestino, nomeUsuarioContaDestino)){
            System.out.println("Usuario destino não possui conta com esse id");
            return false;
        }
        //Verifica se valor aleatório está entre 1000 e 9999
        if ((idTransacao<1000) || (idTransacao>9999)){
            System.out.println("Id da transação fora do range - esperado 1000 > id > 9999 / recebido: " + idTransacao);
            return false;
        }

        return true; //Passou por todas as validações
    }
}