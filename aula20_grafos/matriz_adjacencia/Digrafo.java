package aula20_grafos.matriz_adjacencia;

public class Digrafo {
    private boolean[][] matriz;
    private int vertices;
    public Digrafo(int vertices) {
        this.vertices = vertices;
        matriz = new boolean[this.vertices][this.vertices];
    }
    public void adicionarAresta(int v, int w) {
        matriz[v][w] = true;
    }
    public int getArestas() {
        int arestas = 0;
        for (int l = 0; l < vertices; l++)
            for(int c=0; c<vertices; c++)
                if(matriz[l][c]) arestas++;
        return arestas;
    }
    public boolean existeAresta(int v, int w) {
        return matriz[v][w];
    }
    public void removerAresta(int v, int w) {
        matriz[v][w] = false;
    }
    public int grauSaida(int v) {
        int grauS = 0;
        for(int c=0; c<vertices; c++) {
            if(matriz[v][c]) grauS++;
        }
        return grauS;
    }
    public int grauEntrada(int v) {
        int grauE = 0;
        for(int l=0; l<vertices; l++) {
            if(matriz[l][v]) grauE++;
        }
        return grauE;
    }
    public int getVertices() { return this.vertices; }
    public void imprimirMatriz() {
        String str="  |";
        for (int i = 0; i < vertices; i++) {
            str += "  " + i + "  |";
        }
        System.out.println(str);
        for (int i = 0; i < vertices; i++) {
            String linha = i + " |";
            for (int j = 0; j < vertices; j++) {
                linha += matriz[i][j] + "|";
            }
            System.out.println(linha);
        }
    }
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if(matriz[i][j]) resultado += "\t" + i + "->" + j + ";" + System.lineSeparator();
                if(matriz[j][i] && j!=i) resultado += "\t" + j + "->" + i + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

}
