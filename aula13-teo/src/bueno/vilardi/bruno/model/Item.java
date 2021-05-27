package bueno.vilardi.bruno.model;

/**
 * Classe que representa em um item armazenado no sitema
 */
public class Item {
    final public String nome;
    final public double preco;

    /**
     * Contrutor do elemento item
     * @param nome
     * @param preco
     */
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Metodo que representa o estado do objeto item
     * @return
     */
    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    /**
     * Método que cirar um objeto Item dada um string de entrada
     * @param linha String com os valores do nome e preco separados por vírugla
     * @return
     */
    public static Item pegaItem(String linha){
        return new Item(linha.split(",")[0], Double.parseDouble(linha.split(String.valueOf(","))[1]));
    }
}
