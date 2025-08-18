package ThreadList;

import java.util.List;
import java.util.Random;

/**
 * Classe que popula uma lista de inteiros com numeros aleatorios
 */
public class PopulaLista extends Thread {

    private List<Integer> lista;
    Integer tamanho;

    public PopulaLista(List<Integer> lista, Integer tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    /**
     * Executa a thread que adiciona numeros aleatorios na lista
     */
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            lista.add(random.nextInt(tamanho));
        }
    }
}
