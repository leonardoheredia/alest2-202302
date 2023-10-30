package aula25_grafovaloradocompleto_mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura {
    private boolean[] visitado;
    private int[] antecessor;
    private int[] distancia;
    public BuscaEmLargura(GrafoValorado g, int origem) {
        visitado = new boolean[g.getVertices()];
        antecessor = new int[g.getVertices()];
        distancia = new int[g.getVertices()];
        for (int v = 0; v < g.getVertices(); v++) {
            antecessor[v] = -1;
        }
        buscar(g, origem);
    }
    private void buscar(GrafoValorado g, int origem) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        while (!fila.isEmpty()) {
            int v = fila.poll();
            visitado[v] = true;
            for (ArestaValorada a:g.adjacentes(v)) {
                int w = a.getW();
                int peso = a.getPeso();
                if(!visitado[w]) {
                    fila.add(w);
                    visitado[w] = true;
                    antecessor[w] = v;
                    distancia[w] = distancia[v] + peso;
                }
            }
        }
    }
    public String getVisitados() {
        return Arrays.toString(visitado);
    }
    public String getAntecessor() {
        return Arrays.toString(antecessor);
    }
    public String getDistancias() {
        return Arrays.toString(distancia);
    }
}
