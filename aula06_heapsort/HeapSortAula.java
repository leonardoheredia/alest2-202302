package aula06_heapsort;

import utils.ArrayUtils;

public class HeapSortAula {

    public static void main(String[] args) {
        int[] a = new int[20];
        ArrayUtils.preencherArrayComValoresInteirosAleatorios(a, 100, false);
        ArrayUtils.imprimir(a);
        ordenar(a);
        ArrayUtils.imprimir(a);
    }

    public static void trocar(int[] a, int p1, int p2) {
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }
    public static void ordenar(int[] a) {
        int tamanho = a.length;
        for (int i = tamanho; i >0 ; i--) {
            heapify(a, i-1);
            trocar(a, 0, i-1);
            ArrayUtils.imprimir(a);
        }
    }

    public static void heapify(int[] a, int tamanho) {
        //primeira coisa eh transformar o array a em um heap - heapify
        int ultimaPosicao = tamanho-1;
        int ultimoPai = ultimaPosicao / 2;
        for (int i = ultimoPai; i >=0 ; i--) {
            sinkAfundar(a, tamanho, i);
        }

    }
    public static void sinkAfundar(int[] a, int tamanho, int posicao) {
        while(posicao*2+1 < tamanho) {
            int pMaior = posicao;
            int pEsquerda = posicao*2+1;
            int pDireita = posicao*2+2;

            if(pEsquerda<tamanho && a[pEsquerda]>a[pMaior]) pMaior = pEsquerda;
            if(pDireita<tamanho && a[pDireita]>a[pMaior]) pMaior = pDireita;

            if(pMaior!=posicao) {//significa que um dos filhos eh maior
                int temp = a[posicao];
                a[posicao] = a[pMaior];
                a[pMaior] = temp;
            }
            posicao = posicao*2+1;
        }
    }

}
