package bueno.vilardi.bruno;

import java.util.ArrayList;


public class Usuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>(); //Keep track de todas os usuarios criadas
    public String nomeComleto;
    public String email;
    private String senha;
    private ArrayList<Conta> contas = new ArrayList<>();


    public Usuario(String nomeComleto, String senha, String email) {
        if (Usuario.naoExisteUsuario(nomeComleto)) {
            this.nomeComleto = nomeComleto;
            this.email = email;
            this.senha = AuxiliarFunctions.hashString(senha); //Não armazena a senha do usuário, armazena apenas o Hash - aumenta a segurança
            Usuario.usuarios.add(this);
            System.out.println("Usuário " + nomeComleto + " Criado com sucesso!");
        } else {
            System.out.println("Não foi possível criar o usuário " + nomeComleto);
        }


    }

    public static boolean naoExisteUsuario(String nomeComleto) {
        for (Usuario i : Usuario.usuarios) {
            if (i.nomeComleto.equals(nomeComleto)){
                return false;
            }
        }
        return true;
    }

    public static Usuario getUsuarioPeloNome(String nome){
        for(Usuario i : Usuario.usuarios){
            if (i.nomeComleto.equals(nome)){
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
        if (senhaHash.equals(user.senha)){
            Sistema.usuarioLogado = user;
            return true;
        }
        return false;
    }

    public static void exibirUsuarios(Usuario usuarioLogado) {
        if (usuarioLogado.nomeComleto.equals("admin")){
            System.out.println(Usuario.usuarios);
        } else {
            System.out.println("Usuário logado não tem permissão");
        }
    }

    public boolean atribuirConta(Conta conta){
        this.contas.add(conta);
        return true;
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "nomeComleto='" + nomeComleto + '\'' +
                //", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", contas=" + contas +
                '}';
    }
}
