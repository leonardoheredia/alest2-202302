package aula20_grafos.lista_adjacencia;

public class ListaAdjacenteApp {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.adicionarAresta(2,1);
        g.adicionarAresta(2,3);
        System.out.println(g.toDot());
        System.out.println(g);
    }
}
