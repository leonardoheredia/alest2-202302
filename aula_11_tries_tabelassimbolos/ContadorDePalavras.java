package aula_11_tries_tabelassimbolos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorDePalavras {
    public static void main(String[] args) throws FileNotFoundException {

        TabelaSimbolos<String, Integer> tabelaPalavras = new TabelaSimbolos<>();
        Scanner leitor = new Scanner(new File("tale.txt"));

        while(leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            linha = linha.replace(".","").replace(",", "");
            String[] palavras = linha.split(" ");
            for (String p:palavras) {
                if(tabelaPalavras.contem(p)) {
                    int quantidade = tabelaPalavras.buscar(p);
                    tabelaPalavras.atualizar(p, quantidade+1);
                }
                else {
                    tabelaPalavras.atualizar(p, 1);
                }
            }
        }
        tabelaPalavras.imprimir();
    }
}
