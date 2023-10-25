package aula24_ordenacaotopo_valorado;

public class AppGrafoDirecionado {
    public static void main(String[] args) {
        GrafoDirecionado g = new GrafoDirecionado(5);
        g.adicionarAresta(1,0);
        g.adicionarAresta(1,4);
        g.adicionarAresta(2,0);
        g.adicionarAresta(2,1);
        g.adicionarAresta(2,4);
        g.adicionarAresta(3,1);
        g.adicionarAresta(3,2);
        g.adicionarAresta(3,4);
        System.out.println(g.toDot());

        //BuscaEmProfundidade bf = new BuscaEmProfundidade(g, 0);
        //System.out.println(bf.getPreOrdem());
        //System.out.println(bf.getPosOrdem());
        //System.out.println(bf.getOrdenacaoTopologica());
        for (int i = 0; i < g.getVertices(); i++) {
            BuscaEmProfundidade bf = new BuscaEmProfundidade(g, i);
            System.out.println(bf.getOrdenacaoTopologica());
        }

    }
}
