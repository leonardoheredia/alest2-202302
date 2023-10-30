package aula25_grafovaloradocompleto_mst;

import java.util.ArrayList;

public class AppGrafoValorado {
    public static void main(String[] args) {
        GrafoValorado g = new GrafoValorado(5);
        g.adicionarAresta(0,1, 10);
        g.adicionarAresta(1,2, 10);
        //g.adicionarAresta(0,2, 5);
        g.adicionarAresta(1,3, 7);
        g.adicionarAresta(3,4, 1);
        g.adicionarAresta(2,2,6);

        System.out.println(g.toDot());

        BuscaEmProfundidade bp = new BuscaEmProfundidade(g, 0);

        System.out.println(bp.getPreOrdem());
        System.out.println("");
        System.out.println(bp.getPosOrdem());

        BuscaEmLargura bl = new BuscaEmLargura(g, 0);
        System.out.println(bl.getVisitados());
        System.out.println(bl.getAntecessor());
        System.out.println(bl.getDistancias());
        System.out.println(bp.getContemCiclo());

        for (ArestaValorada a:g.listaArestas()) {
            System.out.println(a.getV() + " " + a.getW() + " - " + a.getPeso());
        }
    }
}
