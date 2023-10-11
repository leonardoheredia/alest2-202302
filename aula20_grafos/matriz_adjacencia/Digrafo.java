package aula20_grafos.matriz_adjacencia;

public class Digrafo {
    private boolean[][] matriz;
    private int vertices;
    public Digrafo(int vertices) {
        this.vertices = vertices;
        matriz = new boolean[this.vertices][this.vertices];
    }
    public void adicionarAresta(int v, int w) {
        //implementar
    }
    public int getArestas() {
        //IMPLEMENTAR
        return 0;
    }
    public boolean existeAresta(int v, int w) {
        //IMPLEMENTAR
        return false;
    }
    public void removerAresta(int v, int w) {
        //IMPLEMENTAR
    }
    public int grau(int v) {
        //IMPLEMENTAR
        return 0;
    }
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
                if(matriz[i][j]) {
                    resultado += "\t" + i + "->" + j + ";" + System.lineSeparator();
                }
            }
        }
        resultado += "}";
        return resultado;
    }

}
