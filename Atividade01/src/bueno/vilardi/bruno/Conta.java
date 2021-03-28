package bueno.vilardi.bruno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Conta {
    public int id;
    private double saldo;
    private Usuario proprietario;
    private static int contador = 1; //Controla o id das contas
    private static ArrayList<Conta> contas = new ArrayList<>(); //Keep track de todas as contas criadas

    public Conta(double saldoInicial, Usuario proprietario) {
        this.id = Conta.contador;
        this.saldo = saldoInicial;
        this.proprietario = proprietario;
        proprietario.atribuirConta(this); //Atribui a nova conta para a lista de contas daquele usuário
        Conta.contas.add(this);           //Atribui a nova conta para a lista de contas existentes no sistema
        contador++;
        System.out.println("nova Conta (" + id + ") de " + proprietario.nomeComleto + " criada com sucesso!");
    }

    public static void exibirContas(Usuario usuarioLogado) {
        if (usuarioLogado.nomeComleto.equals("admin")){
            System.out.println(Conta.contas);
        } else {
            System.out.println("Usuário não tem permissões");
        }
    }

    private void adicionarDinheiro(double valor){ //Adiciona valor no saldo da conta
        this.saldo += valor;
    }

    private boolean retirarDinheiro(double valor){ //Retira dinheiro do saldo conta se possível - retorna se deu certo
        if(valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferirDinheiro(String s){ //Transfere dinheiro com os parametros da string do QR Code

        //Carrega os dados da string em variáveis locais
        String[] dados = s.split(";"); //Dados: "idConta;nomeUsuario;valor;numeroAleatorio"
        int idContaDestino = Integer.parseInt(dados[0]);
        String nomeUsuarioContaDestino = dados[1];
        double valor = Double.parseDouble(dados[2]);
        int idTransacao = Integer.parseInt(dados[3]);

        //Exibição visual da transferencia
        System.out.println("Transferindo " + valor + " de " + this.proprietario.nomeComleto + " (Conta " + this.id + ") para " + nomeUsuarioContaDestino +
               "(Conta " + idContaDestino + ") - transação id " + idTransacao);

        if (this.retirarDinheiro(valor)){
            Conta.getConta(idContaDestino).adicionarDinheiro(valor);
            return true;
        }
        return false;
    }

    public static Conta getConta(int contaId){ //Retorna objeto Conta com id especificado ou null, caso não exista a conta
        for(Conta i : Conta.contas) {
            if (i.id == contaId) {
                return i;
            }
        }
        return null;
    }

    public String getNomeProprietario(){
        return this.proprietario.nomeComleto;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", proprietario=" + proprietario.nomeComleto +
                '}';
    }
}

