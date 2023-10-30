package aula25_grafovaloradocompleto_mst;

import java.util.ArrayList;

public class GrafoValorado {
    // Grafo Valorado Não Direcionado
    // BUG CONHECIDO -> NAO RETORNA ARESTA SELF LOOP NO listaArestas
    private int vertices;
    private int arestas;
    private ArrayList<ArestaValorada>[] listaAdjacencia;
    public GrafoValorado(int vertices) {
        this.vertices = vertices;
        this.arestas = 0; //so para ficar explicito
        listaAdjacencia = new ArrayList[this.vertices];
        for (int v = 0; v < this.vertices; v++) {
            listaAdjacencia[v] = new ArrayList<ArestaValorada>();
        }
    }
    public void adicionarAresta(int v, int w, int peso) {
        ArestaValorada a = new ArestaValorada(v, w, peso);
        listaAdjacencia[v].add(a);
        listaAdjacencia[w].add(a);
        arestas++;
    }
    public Iterable<ArestaValorada> adjacentes(int vertice) {
        return listaAdjacencia[vertice];
    }
    public Iterable<ArestaValorada> listaArestas() {
        ArrayList<ArestaValorada> lista = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            for (ArestaValorada a:listaAdjacencia[v]) {
                if(a.getW()>v) {
                    lista.add(a);
                }
            }
        }
        return lista;
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < this.vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        boolean[][] jaImpresso = new boolean[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                ArestaValorada aresta = listaAdjacencia[i].get(j);
                int v = aresta.getV();
                int w = aresta.getW();
                int peso = aresta.getPeso();
                if(!jaImpresso[v][w] && !jaImpresso[w][v]) {
                    resultado += "\t" + v + "--" + w + "  [label=" + peso + "]" + ";" + System.lineSeparator();
                    jaImpresso[v][w] = true;
                    jaImpresso[w][v] = true;
                }
            }
        }
        resultado += "}";
        return resultado;
    }
    public int grau(int vertice) {
        return listaAdjacencia[vertice].size();
    }
    public int getVertices() {
        return this.vertices;
    }


}
