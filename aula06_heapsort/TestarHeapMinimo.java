package aula06_heapsort;
import utils.ArrayUtils;

import java.util.Scanner;

public class TestarHeapMinimo {

    public static void main(String[] args) {
        testarHeapMinimo();
    }
    public static void testarHeapMinimo() {
        Scanner teclado = new Scanner(System.in);
        HeapMinimo h1 = new HeapMinimo(5);

        String schave;
        int chave;
        System.out.println("Digite os valores a serem inseridos ('s' para encerrar ou 'r' para remover o maximo)");
        do {
            schave=teclado.nextLine();
            if(schave.equals("r")) {
                //h1.removerMaximo();
            }
            else if(schave.matches("[0-9]+")){
                chave = Integer.parseInt(schave);
                h1.inserir(chave);
            }
            ArrayUtils.imprimir(h1.getChaves());
            System.out.println("");
        }while(!schave.equals("s"));

    }
}
