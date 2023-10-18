package aula21_caminhamento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura {
    private boolean[] visitado;
    private int[] antecessor;
    public BuscaEmLargura(GrafoNaoDirigido g, int origem) {
        visitado = new boolean[g.getVertices()];
        antecessor = new int[g.getVertices()];
        for (int i = 0; i < antecessor.length ; i++) {
            antecessor[i] = -1;
        }
        buscar(g, origem);
    }
    private void buscar(GrafoNaoDirigido g, int origem) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        while (!fila.isEmpty()) {
            int v = fila.poll();
            visitado[v] = true;
            ArrayList<Integer> adjacentes = g.adjacentes(v);
            for (int w:adjacentes) {
                if(!visitado[w]) {
                    fila.add(w);
                    visitado[w] = true;
                    antecessor[w] = v;
                }
            }
        }
    }
}

