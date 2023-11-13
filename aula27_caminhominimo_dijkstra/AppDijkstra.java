package aula27_caminhominimo_dijkstra;

public class AppDijkstra {
    public static void main(String[] args) {
        DigrafoValorado g = new DigrafoValorado(5);
        g.adicionarAresta(0,1, 500);
        g.adicionarAresta(1,2, 300);
        g.adicionarAresta(0, 3, 159);
        g.adicionarAresta(2,3, 40);
        g.adicionarAresta(0,4,9999);
        g.adicionarAresta(3,4,34);
        System.out.println(g.toDot());

        Dijkstra d = new Dijkstra(g, 0);
        d.imprimirResultado();


    }
}
