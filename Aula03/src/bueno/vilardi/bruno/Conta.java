package bueno.vilardi.bruno;

public class Conta {
    //Atributos da Classe
    Cliente cliente = new Cliente();
    double saldo;
    int numero;

    //Métodos da Classe

    void depositar(double valor){
        this.saldo += valor;
    }

    boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    boolean transferirDinheiro(Conta destino, double valor){
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    void visualizarSaldo(){
        System.out.println("Saldo atual: R$ " + this.saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente +
                ", saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
