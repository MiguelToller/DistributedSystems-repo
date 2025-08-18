package ThreadList;

import java.util.List;

/**
 * Classe que calcula a media dos elementos de uma lista de inteiros
 */
public class MediaLista extends Thread {

    private List<Integer> lista;
    private int tamanho;
    private double soma;

    public MediaLista(List<Integer> lista, Integer tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
        this.soma = 0;
    }

    /**
     * Calcula a soma dos elementos da lista
     */
    @Override
    public void run() {
        for (int i = 0; i < tamanho; i++) {
            soma += lista.get(i);
        }
    }

    /**
     * Calcula a media da lista de inteiros
     * @return a media dos elementos na lista
     */
    public double getMedia() {
        return soma / tamanho;
    }
}
