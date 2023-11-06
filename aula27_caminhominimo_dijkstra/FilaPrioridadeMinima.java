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
        //IMPLEMENTAR
    }
    public boolean estaVazia() {
        return itens.isEmpty();
    }
    public int desenfileirar() {
        //IMPLEMENTAR
        return -1;
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
