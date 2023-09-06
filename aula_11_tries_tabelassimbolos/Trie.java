package aula_11_tries_tabelassimbolos;

import java.util.LinkedList;
import java.util.Queue;

public class Trie {
    private static final int TAMANHO_ALFABETO = 26;        //apenas letras maiusculas
    private class Nodo {
        private char valor;
        private int nivel;
        private Nodo[] proximo;

        public Nodo() {
            this.proximo = new Nodo[TAMANHO_ALFABETO];
            this.nivel = 0;
        }
    }

    private Nodo raiz;
    private int quantidade;

    public Trie() {
        this.quantidade = 0;
        this.raiz = new Nodo();
    }

    public void adicionar(String chave) {
        Nodo aux = this.raiz;
        int nivel = this.raiz.nivel;
        for (int i = 0; i < chave.length(); i++) {
            int posicaoNoArray = chave.charAt(i) - 65;
            if (aux.proximo[posicaoNoArray] == null) {
                Nodo novoNodo = new Nodo();
                novoNodo.valor = chave.charAt(i);
                novoNodo.nivel = nivel;
                aux.proximo[posicaoNoArray] = novoNodo;
            }
            nivel++;
            aux = aux.proximo[posicaoNoArray];
        }
    }

    public boolean buscar(String chave) {
        //retorna true ou false se a chave existe na TRIE
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < chave.length(); i++) {
            q.add((int)chave.charAt(i));
        }
        Nodo aux = this.raiz;
        int c = q.peek();
        for (int i = 0; i < aux.proximo.length; i++) {
            if(aux.proximo[i]!=null && i==c-65) {
                c = q.remove();
                c = q.peek();
                if(q.isEmpty()) {
                    System.out.println("ACHOU");
                    break;
                }
                aux = aux.proximo[i];
            }
        }
        return false;
    }

    public void imprimir() {
        //IMPLEMENTAR EM AULA
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.adicionar("JANTA");
        t.adicionar("JATO");
        t.adicionar("JATOBA");
        t.imprimir();
        t.buscar("JATO");
    }

}
