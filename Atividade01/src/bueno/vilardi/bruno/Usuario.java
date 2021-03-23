package bueno.vilardi.bruno;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>(); //Keep track de todas os usuarios criadas
    public String nomeComleto;
    public String email;
    private String senha;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Usuario(String nomeComleto, String senha, String email) {
        this.nomeComleto = nomeComleto;
        this.email = email;
        this.senha = AuxiliarFunctions.hashString(senha); //Não armazena a senha do usuário, armazena apenas o Hash - aumenta a segurança

    }

    public static Usuario getUsuarioPeloNome(String nome){
        for(Usuario i : Usuario.usuarios){
            if (i.nomeComleto == nome){
                return i;
            }
        }
        return null;
    }

    public static boolean autenticarUsuario(String nome, String senha) {
        Usuario user = Usuario.getUsuarioPeloNome(nome);
        if (user == null){
            return false;
        }
        String senhaHash = AuxiliarFunctions.hashString(senha);
        if (senhaHash == user.senha){
            Sistema.usuarioLogado = user;
            return true;
        }
        return false;
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
