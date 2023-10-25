package aula24_ordenacaotopo_valorado;

public class AppGrafoDirecionado {
    public static void main(String[] args) {
        GrafoDirecionado g = new GrafoDirecionado(5);
        g.adicionarAresta(4,2);
        g.adicionarAresta(2,3);
        g.adicionarAresta(3,1);
        g.adicionarAresta(4,3);
        g.adicionarAresta(2,1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,4);
        System.out.println(g.toDot());

        BuscaEmProfundidade bf = new BuscaEmProfundidade(g, 0);
        System.out.println(bf.getPreOrdem());
        System.out.println(bf.getPosOrdem());
        System.out.println(bf.getOrdenacaoTopologica());

    }
}
