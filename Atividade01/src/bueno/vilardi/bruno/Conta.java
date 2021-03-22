package bueno.vilardi.bruno;

import java.util.ArrayList;

public class Conta {
    public int id;
    private double saldo;
    private Usuario proprietario;
    private static int contador = 1;

    public Conta(double saldo, Usuario proprietario) {
        this.id = Conta.contador;
        this.saldo = saldo;
        this.proprietario = proprietario;
        proprietario.atribuirConta(this);
        contador++;
    }

    private void depositar(double valor){
        this.saldo += valor;
    }

    private boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferirDinheiro(String s){
        String[] dados = s.split(";");
        System.out.println(dados);
        /*
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;*/
    }

    @Override
    public static String toString() {
        return "Conta{" +
                "id=" + this.id +
                ", saldo=" + this.saldo +
                '}';
    }

}

