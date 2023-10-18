package aula20_grafos.lista_adjacencia;

import java.util.ArrayList;

public class Grafo {
    private int vertices;
    private ArrayList<Integer>[] listaAdjacencia;
    private int arestas;
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        listaAdjacencia = new ArrayList[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w) {
        listaAdjacencia[v].add(w);
        listaAdjacencia[w].add(v);
        arestas++;
    }
    public void removerAresta(int v, int w) {
        if(arestas==0) return;
        listaAdjacencia[v].remove((Object)w);
        listaAdjacencia[w].remove((Object)v);
        arestas--;
    }
    public boolean existeAresta(int v, int w) {
        return listaAdjacencia[v].contains(w);
    }
    public int getVertices() {
        return this.vertices;
    }
    public int getArestas() {
        return this.arestas;
    }
    public int grau(int vertice) {
        return listaAdjacencia[vertice].size();
    }
    public ArrayList<Integer> adjacentes(int v) {
        //retornar uma array list com os vertices adjacentes ao vertice V
        ArrayList<Integer> r;
        r = (ArrayList<Integer>) listaAdjacencia[v].clone();
        return r;
    }
    @Override
    public String toString() {
        String s = "";
        for (int v = 0; v < listaAdjacencia.length; v++) {
            s = s + "\n" + v + " - ";
            for (Integer vAdj:listaAdjacencia[v]) {
                s = s + vAdj + "  ";
            }
        }
        return s;
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "--" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

}
