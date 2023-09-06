package aula_11_tries_tabelassimbolos;

public class DemoTabelaSimbolos {
    public static void main(String[] args) {
        TabelaSimbolos<String, String> ts = new TabelaSimbolos<>();
        ts.atualizar("IBL-1145", "FUSCA");
        ts.atualizar("IGG-9933", "CHEVETTE");
        ts.atualizar("BMW-9945", "BMW Z3");
        ts.atualizar("IBL-1145", "OPALA");
        ts.imprimir();
        String v = ts.buscar("IGG-9933");
        System.out.println(v);
    }
}
