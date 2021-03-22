package bueno.vilardi.bruno;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nomeComleto;
    String senha;
    String email;
    ArrayList<Conta> contas = new ArrayList<>();

    public Usuario(String nomeComleto, String senha, String email) {
        this.nomeComleto = nomeComleto;
        this.email = email;
        this.senha = senha;
    }

    public boolean atribuirConta(Conta conta){
        this.contas.add(conta);
        return true;
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "nomeComleto='" + nomeComleto + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", contas=" + contas +
                '}';
    }
}
