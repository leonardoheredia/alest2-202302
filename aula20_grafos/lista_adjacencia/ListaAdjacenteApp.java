package aula20_grafos.lista_adjacencia;

public class ListaAdjacenteApp {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.adicionarAresta(2,1);
        g.adicionarAresta(2,3);
        System.out.println(g.toDot());
        System.out.println(g);
        System.out.println(g.existeAresta(0,1)); //FALSE
        System.out.println(g.existeAresta(2,3)); //TRUE
        System.out.println(g.grau(3)); //TEM QUE RETORNAR 1
        
        System.out.println(g.adjacentes(2));
    }
}

