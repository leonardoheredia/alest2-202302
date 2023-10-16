package aula20_grafos.matriz_adjacencia;

import aula20_grafos.matriz_adjacencia.Digrafo;
import aula20_grafos.matriz_adjacencia.Grafo;

public class MatrizAdjacenciaApp {
    public static void main(String[] args) {
        //exemploGrafo();
        exemploDigrafo();
    }
    public static void exemploGrafo() {
        Grafo g = new Grafo(5);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,0);
        g.adicionarAresta(2,4);
        System.out.println(g.toDot());
        g.imprimirMatriz();
        System.out.println("Arestas = " + g.getArestas());

        for (int v = 0; v < g.getVertices(); v++) {
            System.out.println("Grau vertice " + v + ": " + g.grau(v));
        }

        System.out.println("");
        g.removerAresta(0, 2);
        System.out.println(g.toDot());
        g.imprimirMatriz();
        System.out.println("Arestas = " + g.getArestas());

        for (int v = 0; v < g.getVertices(); v++) {
            System.out.println("Grau vertice " + v + ": " + g.grau(v));
        }
    }
    public static void exemploDigrafo() {
        Digrafo g = new Digrafo(5);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(0, 0);
        g.adicionarAresta(2, 4);
        g.adicionarAresta(1,0);
        System.out.println(g.toDot());
        g.imprimirMatriz();
        System.out.println("Arestas = " + g.getArestas());

        for (int v = 0; v < g.getVertices(); v++) {
            System.out.println("Grau vertice " + v + ":  saida(" + g.grauSaida(v) + ")  entrada ("  + g.grauEntrada(v) + ")");
        }
    }
}
