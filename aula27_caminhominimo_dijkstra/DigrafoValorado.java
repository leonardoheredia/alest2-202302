package aula27_caminhominimo_dijkstra;

import java.util.ArrayList;

public class DigrafoValorado {
    private int numeroVertices;
    private int numeroArestas;
    private ArrayList<ArestaDirecionadaValorada>[] listaAdjacencia;
    public DigrafoValorado(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        listaAdjacencia = new ArrayList[numeroVertices];
        for (int v = 0; v < numeroVertices; v++) {
            listaAdjacencia[v] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int origem, int destino, int peso) {
        ArestaDirecionadaValorada a = new ArestaDirecionadaValorada(origem, destino, peso);
        listaAdjacencia[origem].add(a);
        numeroArestas++;
    }
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) resultado += "\t" + listaAdjacencia[i].get(j).getOrigem() + "->" + listaAdjacencia[i].get(j).getDestino() + "  [label=" + listaAdjacencia[i].get(j).getPeso() + "]" + ";" + System.lineSeparator();
        }
        resultado += "}";
        return resultado;
    }
    public int getNumeroVertices() {
        return numeroVertices;
    }

    public int getNumeroArestas() {
        return numeroArestas;
    }
    public Iterable<ArestaDirecionadaValorada> arestas(int vertice) {
        return listaAdjacencia[vertice];
    }
}
