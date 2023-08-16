package aula03_analise_algoritmos_ordenacao;

import utils.ArrayUtils;

import java.lang.reflect.Array;

public class AnaliseOrdenacao {

    public static void main(String[] args) {
        int[] arrayBubble;
        int[] arrayInsertion;
        int[] arrayMerge;
        int[] arrayQuick;
        int TAM_MAXIMO = 50_000;

        System.out.println("n;bubble;insertion;merge;quick");
        for (int n = 10; n <= TAM_MAXIMO ; n+=500) {
            arrayBubble = new int[n];
            arrayInsertion = new int[n];
            arrayMerge = new int[n];
            arrayQuick = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(arrayBubble,1000, true);
            ArrayUtils.clonarArray(arrayBubble, arrayInsertion);
            ArrayUtils.clonarArray(arrayBubble, arrayMerge);
            ArrayUtils.clonarArray(arrayBubble, arrayQuick);

            BubbleSort bs = new BubbleSort();
            bs.ordenar(arrayBubble);

            InsertionSort is = new InsertionSort();
            is.ordenar(arrayInsertion);

            MergeSort ms = new MergeSort();
            ms.ordenar(arrayMerge);

            QuickSort qs = new QuickSort();
            qs.ordenar(arrayQuick);

            System.out.println(n + ";"
                    + bs.getOperacoes()
                    + ";" + is.getOperacoes()
                    + ";" + ms.getOperacoes()
                    + ";" + qs.getOperacoes()
            );
        }


    }

}
