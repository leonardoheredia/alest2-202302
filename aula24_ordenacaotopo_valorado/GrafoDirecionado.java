package aula24_ordenacaotopo_valorado;

import java.util.ArrayList;
import java.util.Collections;

public class GrafoDirecionado {
    //GrafoDirecionado = Digrafo
    private int vertices;
    private int arestas;
    private ArrayList<Integer>[] listaAdjacencia;
    public int getVertices() {return vertices;}
    public int getArestas() {return arestas;}
    public GrafoDirecionado(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        listaAdjacencia = new ArrayList[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w) {
        listaAdjacencia[v].add(w);
        arestas++;
    }
    public ArrayList<Integer> adjacentes(int vertice) {
        ArrayList<Integer> l = (ArrayList<Integer>) listaAdjacencia[vertice].clone();
        Collections.sort(l);
        return (ArrayList<Integer>) l;
    }
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "->" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

}
