package aula25_grafovaloradocompleto_mst;

public class ArestaValorada implements Comparable<ArestaValorada>{
    private int v;
    private int w;
    private int peso;
    public ArestaValorada(int v, int w, int peso) {
        this.v = v;
        this.w = w;
        this.peso = peso;
    }
    public int getV() {
        return v;
    }
    public int getW() {
        return w;
    }
    public int adjacente(int vertice) {
        if(vertice==v) return w;
        else return v;
    }
    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(ArestaValorada outraAresta) {
        if(this.peso<outraAresta.peso) return -1;
        else if(this.peso>outraAresta.peso) return 1;
        else return 0;
    }

}
