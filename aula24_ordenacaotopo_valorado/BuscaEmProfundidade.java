package aula24_ordenacaotopo_valorado;

import java.util.ArrayList;
import java.util.Collections;

public class BuscaEmProfundidade {
    private boolean[] visitado;
    private int[] antecessor;
    private ArrayList<Integer> preOrdem;
    private ArrayList<Integer> posOrdem;
    public BuscaEmProfundidade(GrafoDirecionado g, int origem) {
        visitado = new boolean[g.getVertices()];
        preOrdem = new ArrayList<>();
        posOrdem = new ArrayList<>();
        antecessor = new int[g.getVertices()];
        for (int i = 0; i < antecessor.length; i++) {
            antecessor[i] = -1;
        }
        buscarEmProfundidade(g, origem);
    }
    public void buscarEmProfundidade(GrafoDirecionado g, int vertice) {
        preOrdem.add(vertice);
        visitado[vertice] = true;
        ArrayList<Integer> adjacentes = g.adjacentes(vertice);
        for (int vizinho:adjacentes) {
            if(!visitado[vizinho]) {
                antecessor[vizinho] = vertice;
                buscarEmProfundidade(g, vizinho);
            }
        }
        posOrdem.add(vertice);
    }
    public String getPreOrdem() {
        return preOrdem.toString();
    }
    public String getPosOrdem() {
        return posOrdem.toString();
    }
    public String getOrdenacaoTopologica() {
        ArrayList<Integer> l = (ArrayList<Integer>) posOrdem.clone();
        Collections.reverse(l);
        return l.toString();
    }

}
