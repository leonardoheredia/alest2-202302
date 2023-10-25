package aula22_busca_em_largura;
import java.util.ArrayList;

public class BuscaEmProfundidade {
    private boolean[] visitado;
    private int[] antecessor;
    public BuscaEmProfundidade(GrafoNaoDirigido g, int origem) {
        visitado = new boolean[g.getVertices()];
        antecessor = new int[g.getVertices()];
        for(int i=0; i<antecessor.length; i++) antecessor[i] = -1;

        buscarRecursivo(g, origem);
    }
    private void buscarRecursivo(GrafoNaoDirigido g, int vertice) {
        visitado[vertice] = true;
        ArrayList<Integer> adjacentes = g.adjacentes(vertice);
        for (int vizinho:adjacentes) {
            if(!visitado[vizinho]) {
                antecessor[vizinho] = vertice;
                buscarRecursivo(g, vizinho);
            }
        }
    }
    public String getCaminhos() {
        String r = " v visit ant\n";
        r = r +    " - ----- ---\n";
        for (int i = 0; i < antecessor.length; i++) {
            r = r + " " + i + " " + visitado[i] + " " + antecessor[i] + " \n";
        }
        return r;
    }

}







