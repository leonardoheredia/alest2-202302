package aula03_analise_algoritmos_ordenacao;

public class QuickSort {
    private static int numOperacoes = 0;

    public int ordenar(int[] arr) {
        numOperacoes = 0;
        ordenar(arr, 0, arr.length - 1);
        return numOperacoes;
    }

    private static void ordenar(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(arr, inicio, fim);
            ordenar(arr, inicio, indicePivo - 1);
            ordenar(arr, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] arr, int inicio, int fim) {
        int pivo = arr[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            numOperacoes++;
            if (arr[j] < pivo) {
                i++;
                trocar(arr, i, j);
            }
        }

        trocar(arr, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] arr, int i, int j) {
        numOperacoes++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getOperacoes(){
        return numOperacoes;
    }
}
