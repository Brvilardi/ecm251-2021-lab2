package bueno.vilardi.bruno;

public class D4TestDrive {
    public static void main(String[] args) {
        Dado d1 = new D4();
        for (int i = 0; i < 10; i++) {
            System.out.println("Informações do Dado: ");
            System.out.println("Lancamento: " + d1.lancarDado());
            System.out.println("Lancamento Atual: " + d1.lerLancamentoAtual());
        }
    }
}
