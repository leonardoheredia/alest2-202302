package aula25_grafovaloradocompleto_mst;

import java.util.ArrayList;

public class BuscaEmProfundidade {
    private boolean visitado[];
    private int antecessor[];
    private ArrayList<Integer> preOrdem;
    private ArrayList<Integer> posOrdem;
    private boolean[] pilhaRecursao; //usada para deteccao de ciclos
    private boolean contemCiclo;
    public BuscaEmProfundidade(GrafoValorado g, int origem) {
        visitado = new boolean[g.getVertices()];
        antecessor = new int[g.getVertices()];
        pilhaRecursao = new boolean[g.getVertices()];
        preOrdem = new ArrayList<>();
        posOrdem = new ArrayList<>();
        for (int v = 0; v < g.getVertices(); v++)  {
            antecessor[v] = -1;
        }
        buscar(g, origem);
    }
    private void buscar(GrafoValorado g, int vertice) {
        if(pilhaRecursao[vertice]) contemCiclo = true;
        visitado[vertice] = true;
        pilhaRecursao[vertice] = true;
        preOrdem.add(vertice);
        for (ArestaValorada a:g.adjacentes(vertice)) {
            int adjacente = a.adjacente(vertice);
            int peso = a.getPeso();
            if(!visitado[adjacente]) {
                antecessor[adjacente] = vertice;
                buscar(g, adjacente);
            }
            else if (adjacente!=antecessor[adjacente]) {
                if(pilhaRecursao[adjacente]) contemCiclo = true;
            }
        }
        pilhaRecursao[vertice] = false;
        posOrdem.add(vertice);
    }
    public String getPreOrdem() {
        return preOrdem.toString();
    }
    public String getPosOrdem() {
        return posOrdem.toString();
    }
    public boolean getContemCiclo() {
        return this.contemCiclo;
    }
}
