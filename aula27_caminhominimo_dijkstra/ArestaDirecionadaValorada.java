package aula27_caminhominimo_dijkstra;

public class ArestaDirecionadaValorada {
    private int origem;
    private int destino;
    private int peso;
    public ArestaDirecionadaValorada(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    @Override
    public String toString() {
        return origem + " -> " + destino + " [" + peso + "]";
    }

    public int getOrigem() {
        return origem;
    }

    public int getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}
