package aula06_heapsort;

import utils.ArrayUtils;

public class HeapSort_Aula {

    public static void main(String[] args) {
        int[] a = {12,15,23,16};
        ordenar(a);
    }
    public static void ordenar(int[] arrayInteiros) {
        ArrayUtils.imprimir(arrayInteiros);
        sinkAfundar(arrayInteiros, arrayInteiros.length, 0);
        //transformar em um HeapMaximo
        // [ 12, 15, 23, 16] tam = 4
        /*    0   1   2   3
        *           12
        *     15           23
        * 16
        * */
    }

    public static void sinkAfundar(int[] a, int tamanho, int posicao) {

        while(posicao*2+1 <= tamanho) {

            int pMaior = posicao;
            int pEsquerda = posicao*2+1;
            int pDireita = posicao*2+2;

            if(pEsquerda<tamanho && a[pEsquerda]>a[pMaior]) pMaior=pEsquerda;
            if(pDireita<tamanho && a[pDireita]>a[pMaior]) pMaior=pDireita;

            if(pMaior!=posicao) { //sinal que tem que trocar
                int temp = a[pMaior];
                a[pMaior] = a[posicao];
                a[posicao] = temp;
            }
            posicao = posicao*2+1;
        }
    }
}
