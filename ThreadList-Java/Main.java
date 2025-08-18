package ThreadList;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Main do projeto
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        int totalListas = 10;
        List<List<Integer>> listaDeListas = new ArrayList<>();

        // Cria as listas dentro de lista
        for (int i=0; i < totalListas; i++) {
            listaDeListas.add(new ArrayList<Integer>());
        }

        // Lista de Thread do tipo PopulaLista
        List<PopulaLista> ListaPopulaThreads = new ArrayList<>();

        // Popula as listas
        for (int i=0; i < totalListas; i++) {
            PopulaLista t = new PopulaLista(listaDeListas.get(i), totalListas);
            ListaPopulaThreads.add(t);
            t.start();
        }

        // Esperar as threads terminarem
        for (PopulaLista t : ListaPopulaThreads) {
            t.join();
        }

        // Lista de Thread do tipo MediaLista
        List<MediaLista> ListaMediaThreads = new ArrayList<>();

        // Calcula a media das listas
        for (int i = 0; i < totalListas; i++) {
            MediaLista t = new MediaLista(listaDeListas.get(i), totalListas);
            ListaMediaThreads.add(t);
            t.start();
        }

        // Esperar as threads terminarem
        for (MediaLista t : ListaMediaThreads) {
            t.join();
        }

        // Mostra os valores das listas
        for (int i=0; i < totalListas; i++) {
            System.out.println("Lista " + i + ": " + listaDeListas.get(i));
        }

        // Mostra as medias das listas
        double somaMedias = 0;

        System.out.println();
        for (int i = 0; i < totalListas; i++) {
            double media = ListaMediaThreads.get(i).getMedia();
            somaMedias += media;

            System.out.println("Media da lista " + i + " = " + media);
        }

        double mediaGeral = somaMedias / totalListas;
        System.out.println("\nMedia geral de todas as listas = " + mediaGeral);
    }
}