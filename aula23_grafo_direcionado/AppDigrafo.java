package aula23_grafo_direcionado;

public class AppDigrafo {
    public static void main(String[] args) {
        Digrafo dg = new Digrafo(5);
        dg.adicionarAresta(0,1);
        dg.adicionarAresta(0,3);
        dg.adicionarAresta(2, 4);
        dg.adicionarAresta(3, 2);
        dg.adicionarAresta(3,4);
        System.out.println(dg.toDot());

        BuscaEmProfundidade bf = new BuscaEmProfundidade(dg, 0);
    }
}
