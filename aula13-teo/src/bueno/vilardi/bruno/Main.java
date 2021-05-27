package bueno.vilardi.bruno;

import bueno.vilardi.bruno.model.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
	    File file = new File("dados.txt");

	    //Realiza a leitura
        try {
            // Cria elemento para iterar pelo arquivo
            Scanner scanner = new Scanner(file);

            // Itera pelos elementos do scanner
            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                items.add(Item.pegaItem(linha));
            }
            //exibe um resumo dos dados
            exibeResumo(items);

            //Cria nota
            criarNota(items);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void criarNota (List<Item> items) throws Exception{
        FileWriter fileWriter = new FileWriter("nota.csv");

        fileWriter.append("== Resumo Pedido ===" + "\n");
        fileWriter.append("Total de Items: " + items.size() +"\n");
        double total = 0;
        fileWriter.append("Items: " +"\n");
        for (Item item : items) {
            fileWriter.append(item.nome + "\t" + item.preco +"\n");
            total += item.preco;
        }
        fileWriter.append("Total do pedido: " + total);

        //Fechar o arquivo
        fileWriter.close();

    }

    private static void exibeResumo(List<Item> items) {
        System.out.println("== Resumo Pedido ===");
        System.out.println("Total de Items: " + items.size());
        double total = 0;
        System.out.println("Items: ");
        for (Item item : items) {
            System.out.println(item.nome + "\t" + item.preco);
            total += item.preco;
        }
        System.out.println("Total do pedido: " + total);

    }


}
