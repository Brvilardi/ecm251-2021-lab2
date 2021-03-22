package bueno.vilardi.bruno;

public class Conta {
    int id;
    double saldo;
    Usuario proprietario;

    public Conta(int id, double saldo, Usuario proprietario) {
        this.id = id;
        this.saldo = saldo;
        this.proprietario = proprietario;
        proprietario.atribuirConta(this);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + this.id +
                ", saldo=" + this.saldo +
                '}';
    }
}

