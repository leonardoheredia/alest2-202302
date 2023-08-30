package aula09_tabelas_hash_encadeamento_separado;

public class ListaDuplamenteEncadeada {
    int tamanho;
    Nodo inicio;
    Nodo fim;
    private class Nodo {
        int chave;
        Nodo proximo;
        Nodo anterior;
        public Nodo(int chave) {
            this.chave = chave;
            this.proximo = null;
            this.anterior = null;
        }
    }
    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    public void adicionar(int chave) {
        Nodo novoNodo = new Nodo(chave);
        if(this.tamanho==0) {
            this.inicio = novoNodo;
            this.fim = novoNodo;
        }
        else {
            novoNodo.anterior = this.fim;
            this.fim.proximo = novoNodo;
            this.fim = novoNodo;
        }
        tamanho++;
    }
    public void imprimir() {
        Nodo aux = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(aux.chave);
            aux = aux.proximo;
        }
    }
    public static void main(String[] args) {
        ListaDuplamenteEncadeada ld = new ListaDuplamenteEncadeada();
        ld.adicionar(10);
        ld.adicionar(20);
        ld.imprimir();
    }
}
