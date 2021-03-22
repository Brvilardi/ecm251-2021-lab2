package bueno.vilardi.bruno;

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

    @Override
    public static String toString() {
        return "Conta{" +
                "id=" + this.id +
                ", saldo=" + this.saldo +
                '}';
    }

    


}

