package bueno.vilardi.bruno;

public class Conta {
    //Atributos da Classe
    private Cliente cliente = new Cliente();
    private double saldo;
    private int numero;

    //Métodos da Classe

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferirDinheiro(Conta destino, double valor){
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void visualizarSaldo(){
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
