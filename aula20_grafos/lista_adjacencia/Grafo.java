package aula20_grafos.lista_adjacencia;

import java.util.ArrayList;

public class Grafo {
    private int vertices;
    private ArrayList<Integer>[] listaAdjacencia;
    public Grafo(int vertices) {
        this.vertices = vertices;
        listaAdjacencia = new ArrayList[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w) {
        listaAdjacencia[v].add(w);
        listaAdjacencia[w].add(v);
    }
    public void removerAresta(int v, int w) {

    }
    public boolean existeAresta(int v, int w) {
        return false;
    }
    public int getVertices() {
        return this.vertices;
    }
    public int getArestas() {
        return 0; //retorna o numero de arestas
    }
    public int grau(int vertice) {
        return -1;
    }
    public ArrayList<Integer> adjacentes(int v) {
        //retornar uma array list com os vertices adjacentes ao vertice V
        return null;
    }
    @Override
    public String toString() {
        String s = "";
        for (int v = 0; v < listaAdjacencia.length; v++) {
            s = s + "\n" + v + " - ";
            for (Integer vAdj:listaAdjacencia[v]) {
                s = s + vAdj + ",";
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
