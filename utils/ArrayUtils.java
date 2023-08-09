package utils;

import java.util.Random;

public class ArrayUtils {

    public static void imprimir(int[] arrayInteiro) {
        System.out.printf("%n[");
        for (int i = 0; i < arrayInteiro.length ; i++) {
            System.out.printf(" %d ", arrayInteiro[i]);
        }
        System.out.printf("]");
    }

    public static void imprimirArvoreBinaria(int[] arrayInteiros) {
        //metodo bugado - nao usar
        imprimir(arrayInteiros);
        int niveis = arrayInteiros.length / 3;
        int colunas = (int)Math.pow(niveis, 2);
        System.out.println("Heap");
        int nivel = 0;
        for (int i = 1; i < arrayInteiros.length; i++) {
            int qtdsep = (colunas / ((nivel+1) ))*2;
            String sp = " ".repeat(qtdsep);
            System.out.printf("%s", sp);
            System.out.printf("%d", arrayInteiros[i]);
            if (i>nivel*2 || i==1)  {
                System.out.printf("%n ");
                nivel = i;
            }
        }

    }



    public static boolean valorExisteNoArray(int[] arrayInteiro, int valor) {
        boolean achou = false;
        int i = 0;
        while (!achou && i<arrayInteiro.length) {
            if(arrayInteiro[i] == valor) achou=true;
            i++;
        }
        return achou;
    }
    public static void preencherArrayComValoresInteirosAleatorios(int[] variavelArray, int limiteSuperior, boolean permitirRepetidos) {
        Random geradorRandomico = new Random();
        for (int i = 0; i < variavelArray.length; i++) {
            int valorGerado = geradorRandomico.nextInt(limiteSuperior);
            if(permitirRepetidos) variavelArray[i] = valorGerado;
            else {
                while (valorExisteNoArray(variavelArray, valorGerado)) {
                    valorGerado = geradorRandomico.nextInt(limiteSuperior);
                }
                variavelArray[i] = valorGerado;
            }
        }
    }

    public static int retornarSomaArrayInteiros(int[] arrayInteiros) {
        int soma=0;
        for (int i = 0; i < arrayInteiros.length; i++) {
            soma = soma + arrayInteiros[i];
        }
        return soma;
    }

    public static int dobrarValor(int valorInteiro) {
        int dobro = valorInteiro * 2;
        return valorInteiro;
    }

    public static void clonarArray(int[] arrayInteiroOrigem, int[] arrayInteiroDestino) {
        for (int i = 0; i < arrayInteiroOrigem.length; i++) {
            arrayInteiroDestino[i] = arrayInteiroOrigem[i];
        }
    }


}
