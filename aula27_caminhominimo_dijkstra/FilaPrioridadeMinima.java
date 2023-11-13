package aula27_caminhominimo_dijkstra;

import java.util.ArrayList;

public class FilaPrioridadeMinima {
    private class Nodo {
        int vertice;
        int distancia;

        public Nodo(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

    }
    private ArrayList<Nodo> itens = new ArrayList<>();
    public FilaPrioridadeMinima() {
        this.itens = new ArrayList<>();
    }
    public void enfileirar(int vertice, int distancia) {
        Nodo n = new Nodo(vertice, distancia);
        itens.add(n);
    }
    public boolean estaVazia() {
        return itens.isEmpty();
    }
    public int desenfileirar() {
        if(itens.isEmpty()) return -1;
        Nodo menorDistancia = new Nodo(-1, Integer.MAX_VALUE);

        for (int i = 0; i < itens.size(); i++) {
            Nodo n = itens.get(i);
            if(n.distancia<menorDistancia.distancia) {
                menorDistancia = n;
            }
        }
        int vertice = menorDistancia.vertice;
        itens.remove(menorDistancia);
        return vertice;
    }
    public boolean existe(int vertice) {
        return obterNodo(vertice)!=null;
    }
    private Nodo obterNodo(int vertice) {
        for (Nodo n:itens) {
            if(n.vertice==vertice) return n;
        }
        return null;
    }
    public void atualizarDistancia(int vertice, int distancia) {
        Nodo n = obterNodo(vertice);
        if(n==null) return;
        n.distancia = distancia;
    }
}
