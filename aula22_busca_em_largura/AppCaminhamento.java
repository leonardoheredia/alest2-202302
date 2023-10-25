package aula22_busca_em_largura;

public class AppCaminhamento {
    public static void main(String[] args) {
        GrafoNaoDirigido g = new GrafoNaoDirigido(6);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,2);
        g.adicionarAresta(1,3);
        g.adicionarAresta(1,4);

        BuscaEmProfundidade bp = new BuscaEmProfundidade(g, 0);
        System.out.println(bp.getCaminhos());
        BuscaEmLargura bl = new BuscaEmLargura(g,0);

    }
}
