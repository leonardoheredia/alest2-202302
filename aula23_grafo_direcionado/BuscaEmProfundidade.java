package aula23_grafo_direcionado;

import java.util.ArrayList;

public class BuscaEmProfundidade {
    private boolean[] visitado;
    private int[] antecessor;
    public BuscaEmProfundidade(Digrafo dg, int origem) {
        visitado = new boolean[dg.getVertices()];
        antecessor = new int[dg.getVertices()];
        for(int i=0;i<dg.getVertices();i++) antecessor[i] = -1;
        System.out.println("");
        buscarRecursivo(dg, origem);
    }
    private void buscarRecursivo(Digrafo dg, int vertice) {
        visitado[vertice] = true;
        ArrayList<Integer> vizinhos = dg.adjacentes(vertice);
        for(int v:vizinhos) {
            if(!visitado[v]) {
                antecessor[v] = vertice;
                buscarRecursivo(dg, v);
            }
        }
        System.out.printf(vertice + " ");
    }
}
