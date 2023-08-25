package aula03_analise_algoritmos_ordenacao;

import aula06_heapsort.HeapSort;
import utils.ArrayUtils;

public class AnaliseOrdenacao {

    public static void main(String[] args) {
        int[] arrayBubble;
        int[] arrayInsertion;
        int[] arrayMerge;
        int[] arrayQuick;
        int[] arrayHeap;
        int TAM_MAXIMO = 1_000_000;

        System.out.println("n;bubble op;insertion op;merge op;quick op;heap op;bubble t;insertion t;merge t;quick t;heap t");
        for (int n = 10; n <= TAM_MAXIMO ; n+=1_500) {
            arrayBubble = new int[n];
            arrayInsertion = new int[n];
            arrayMerge = new int[n];
            arrayQuick = new int[n];
            arrayHeap = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(arrayBubble,1000, true);
            ArrayUtils.clonarArray(arrayBubble, arrayInsertion);
            ArrayUtils.clonarArray(arrayBubble, arrayMerge);
            ArrayUtils.clonarArray(arrayBubble, arrayQuick);
            ArrayUtils.clonarArray(arrayBubble, arrayHeap);

            BubbleSort bs = new BubbleSort();
            //bs.ordenar(arrayBubble);

            InsertionSort is = new InsertionSort();
            //is.ordenar(arrayInsertion);

            MergeSort ms = new MergeSort();
            ms.ordenar(arrayMerge);

            QuickSort qs = new QuickSort();
            qs.ordenar(arrayQuick);

            HeapSort hs = new HeapSort();
            hs.ordenar(arrayHeap);

            System.out.println(n + ";"
                    + bs.getOperacoes()
                    + ";" + is.getOperacoes()
                    + ";" + ms.getOperacoes()
                    + ";" + qs.getOperacoes()
                    + ";" + hs.getOperacoes()
                    + ";" + bs.getTempoExecucao()
                    + ";" + is.getTempoExecucao()
                    + ";" + ms.getTempoExecucao()
                    + ";" + qs.getTempoExecucao()
                    + ";" + hs.getTempoExecucao()

            );
        }


    }

}
