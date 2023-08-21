package aula06_heapsort;

import utils.ArrayUtils;

public class HeapMinimo {
    private int capacidade;
    private int tamanho;
    private int[] chaves;
    public int[] getChaves() {return chaves;}
    public HeapMinimo(int capacidade) {
        this.capacidade = capacidade;
        this.tamanho = 0;
        chaves = new int[capacidade];
        for (int i = 0; i < capacidade ; i++) {
            chaves[i] = -1;
        }
    }
    public void inserir(int chave) {
        chaves[tamanho] = chave;
        int posicao = tamanho;
        tamanho++;
        ArrayUtils.imprimir(chaves);
        //comecar a nadar
        while(posicao>0) {
            int elemento = chaves[posicao];
            int paiElemento = chaves[(posicao-1)/2];
            if(elemento<paiElemento) {
                //trocar o pai pelo filho
                int temp = chaves[posicao];
                chaves[posicao] = chaves[(posicao-1)/2];
                chaves[(posicao-1)/2] = temp;
                System.out.println();
                System.out.println("Trocou o " + elemento + " pelo " + paiElemento);
            }
            posicao--;
        }

    }

    public static void main(String[] args) {
        HeapMinimo hmin = new HeapMinimo(5);
        ArrayUtils.imprimir(hmin.chaves);

        hmin.inserir(10);
        hmin.inserir(5);
        hmin.inserir(30);
        hmin.inserir(2);
        ArrayUtils.imprimir(hmin.chaves);
    }


}
