package bueno.vilardi.bruno;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String nomeComleto;
    public String email;
    private String senha;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Usuario(String nomeComleto, String senha, String email) {
        this.nomeComleto = nomeComleto;
        this.email = email;
        this.senha = AuxiliarFunctions.hashString(senha); //Não armazena a senha do usuário, armazena apenas o Hash - aumenta a segurança

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
