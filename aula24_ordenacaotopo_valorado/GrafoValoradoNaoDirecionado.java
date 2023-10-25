package aula24_ordenacaotopo_valorado;

import java.util.ArrayList;

public class GrafoValoradoNaoDirecionado {
    class Aresta {
        int origem;
        int destino;
        int peso;
        public Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }
    private int vertices;
    private int arestas;
    private ArrayList<Aresta>[] listaAdjacencia;
    public GrafoValoradoNaoDirecionado(int vertices) {
        this.vertices = vertices;
        listaAdjacencia = new ArrayList[this.vertices];
        for (int i = 0; i < this.vertices ; i++) {
            listaAdjacencia[i] = new ArrayList<Aresta>();
        }
    }
    public void adicionarAresta(int origem, int destino, int peso) {
        Aresta a1 = new Aresta(origem, destino, peso);
        listaAdjacencia[origem].add(a1);
        Aresta a2 = new Aresta(destino, origem, peso);
        listaAdjacencia[destino].add(a2);
        arestas++;
    }
    public ArrayList<Aresta> adjacentes(int vertice) {
        ArrayList<Aresta> l = (ArrayList<Aresta>) listaAdjacencia[vertice].clone();
        return l;
    }

    //implementar getArestas()
    //implementar removerAresta()
    //implementar getPeso(origem, destino)
    //implementar BUSCAEMPROFUNDIDADE!
    //implementar BUSCAEMLARGURA (calculando o total do caminho)
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < this.vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        boolean[][] jaImpresso = new boolean[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                if(!jaImpresso[i][j]) {
                    resultado += "\t" + listaAdjacencia[i].get(j).origem + "--" + listaAdjacencia[i].get(j).destino+ "  [label=" + listaAdjacencia[i].get(j).peso + "]" + ";" + System.lineSeparator();
                    jaImpresso[listaAdjacencia[i].get(j).origem][listaAdjacencia[i].get(j).origem] = true;
                    jaImpresso[listaAdjacencia[i].get(j).destino][listaAdjacencia[i].get(j).destino] = true;
                }
            }
        }
        resultado += "}";
        return resultado;
    }
}


