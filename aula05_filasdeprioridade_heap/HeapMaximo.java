package aula05_filasdeprioridade_heap;

import utils.ArrayUtils;

/*
 * Estrutura de dados HeapMaximo
 * Implementação para fins didáticos
 * Limitada a números inteiros maiores que 0.
 * O valor -1 na chave indica que a posição do heap está vazia
 * */
public class HeapMaximo {
    private int[] chaves;
    private int capacidade; //capacidade do heap, não a sua quantidade de elementos/chaves
    private int tamanho; //quantidade de elementos/chaves do heap
    public HeapMaximo(int capacidade) {
        this.chaves = new int[capacidade];
        this.tamanho = 0;
    }
    public HeapMaximo(int[] chaves) {
        this.chaves = chaves;
        this.capacidade = this.chaves.length;
        this.tamanho = this.chaves.length-1;
        gerarHeap();
    }
    private void gerarHeap() {
        //um array qualquer recebido no construtor pode nao ser um heap-maximo
        //nesse caso temos que transformar ele em um heap
        //para isso vamos percorrer a arvore a partir do ultimo nodo e "nadarPraCima"
        //funcao bugada - revisar
        int ultimaPosicao = this.tamanho;
        for (int i = ultimaPosicao; i > 0; i--) {
            ArrayUtils.imprimir(chaves);
            swimNadar(i);
        }
    }
    public int[] getChaves() {
        return chaves;
    }
    public void inserir(int chave) {
        //Inserir sempre no final
        System.out.println("Inserindo " + chave);
        int ultimaPosicaoPreenchida = this.tamanho;
        this.chaves[ultimaPosicaoPreenchida + 1] = chave;
        this.tamanho++;
        swimNadar(this.tamanho);
    }
    public void removerMaximo() { //remove o maior elemento, a raiz
        /*
         * Trocar a chave do pai com o último elemento do heap, ou seja o último elemento vira a raiz e a raiz anterior eh removida do heap
         * Isso pode deixar o heap inconsistente, com uma raiz menor que os filhos
         * Entao o algoritmo deve executar a operacao "afundar" até que o heap fique consistente
         * */

        //troca
        int chaveMaxima = this.chaves[1];
        int chaveUltimaPosicao = this.chaves[this.tamanho];
        this.chaves[1] = chaveUltimaPosicao;
        this.chaves[this.tamanho] = chaveMaxima;

        //remove a antiga raiz
        this.chaves[this.tamanho] = 0;
        this.tamanho = this.tamanho - 1;

        System.out.println("Removido " + chaveMaxima);
        //inicia o ajuste afundando a nova raiz ate que o heap seja restaurado
        sinkAfundar(1);
    }
    private void sinkAfundar(int posicao) {
        while(2 * posicao <= this.tamanho) {
            int filho = 2 * posicao; //pega o primeiro filho da posicao
            if (filho < this.tamanho && chaves[filho] < chaves[filho+1]) filho++;
            if (chaves[posicao] >= chaves[filho]) break; // pai maior que o maior filho
            int temp = chaves[posicao];
            chaves[posicao] = chaves[filho];
            chaves[filho] = temp;
            posicao = filho;
        }
    }
    private void swimNadar(int posicao) {
        while(posicao > 1 && chaves[posicao/2] < chaves[posicao]) {
            int chave = this.chaves[posicao];
            int chavePai = this.chaves[posicao / 2];
            System.out.printf("   Trocando %d por %d.", chave, chavePai);
            this.chaves[posicao] = chavePai;
            this.chaves[posicao / 2] = chave;
            posicao = posicao / 2; //sobe na arvore
        }
    }
    public void ordernarHeapSort() {
        //IMPLEMENTAR
    }
}

