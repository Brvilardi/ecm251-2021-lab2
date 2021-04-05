package bueno.vilardi.bruno;

import java.util.Random;

public class Dado {
    final private int numeroFaces; //Final significa que o valor não muda
    private int faceAtual;
    private int[] FACES;

    /**
     * Construtor da classe que define o número de faces, as faces e a face inicial do dado
     * @param numeroFaces
     */
    public Dado(int numeroFaces){
        this.numeroFaces = numeroFaces;
        this.FACES = new int[this.numeroFaces];
        for (int i=0; i < this.numeroFaces; i++){
            FACES[i] = i+1;
        }
        this.lancarDado();
    }

    /**
     * Método que sorteia uma face do dado.
     * @return Face atual sorteada
     */
    public int lancarDado(){
        Random random = new Random();

        this.faceAtual = random.nextInt(this.numeroFaces);
        return this.lerLancamentoAtual();
    }

    /**
     * Método que devolve o valor do últumo lançamento do dado
     * @return Última face sorteada
     */
    public int lerLancamentoAtual(){
        return FACES[faceAtual];
    }


}


