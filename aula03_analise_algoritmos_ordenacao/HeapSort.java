package aula03_analise_algoritmos_ordenacao;

import aula05_filasdeprioridade_heap.HeapMaximo;
import utils.ArrayUtils;

public class HeapSort {
    private int operacoes;
    private long tempoInicio;
    private long tempoFim;
    public int getOperacoes() {
        return operacoes;
    }

    public long getTempoExecucao() {
        long tempoExecucao = (tempoFim - tempoInicio) / 1_000 ;
        return tempoExecucao;
    }

    public void ordenarUsandoClasseHeapMaximo(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;

        HeapMaximo heap = new HeapMaximo(arrayInteiros); //gera um heap com o array nao ordenado
        //a partir desse ponto vai extraindo o elemento mais prioritario do heap - no caso estamos com o heap maximo entao teremos
        int tamanho = heap.getTamanho();
        for (int i = 0; i < tamanho; i++) {
            int n = heap.removerMaximo();
            System.out.println("");
            System.out.println("Removido -->" + n);
            arrayInteiros[tamanho-i-1] = n;
        }
        tempoFim = System.nanoTime();
    }

    public void ordenar(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;

        //transforma o array em um heapmaximo
        int ultimaPosicao = arrayInteiros.length - 1;
        int ultimoPai = ultimaPosicao / 2;
        for (int i = ultimoPai; i >= 0; i--) {
            sinkAfundar(arrayInteiros, arrayInteiros.length, i);
        }

        //agora comeca a trocar a primeira posicao pela ultima e executando o sink a cada iteracao
        int tamanho = arrayInteiros.length-1;
        while(tamanho>=0) {
            int temp = arrayInteiros[tamanho]; //ultimo elemento
            arrayInteiros[tamanho] = arrayInteiros[0];
            arrayInteiros[0] = temp;
            tamanho--;
            sinkAfundar(arrayInteiros, tamanho, 0);
        }

        tempoFim = System.nanoTime();
    }

    private void sinkAfundar(int[] arrayInteiros, int tamanho, int posicao) {
        while(2*posicao+1 <= tamanho) {
            operacoes++;
            int maior = posicao;
            int filhoEsquerda = posicao*2 + 1;
            int filhoDireita = posicao*2 + 2;

            if(filhoEsquerda < tamanho && arrayInteiros[filhoEsquerda] > arrayInteiros[maior]) maior = filhoEsquerda;
            if(filhoDireita < tamanho && arrayInteiros[filhoDireita] > arrayInteiros[maior]) maior = filhoDireita;

            if(maior!=posicao) { //tem que trocar posicao pelo maior
                operacoes++;
                int temp = arrayInteiros[posicao];
                arrayInteiros[posicao] = arrayInteiros[maior];
                arrayInteiros[maior] = temp;
            }
            posicao = 2*posicao+1;
        }
    }


}
