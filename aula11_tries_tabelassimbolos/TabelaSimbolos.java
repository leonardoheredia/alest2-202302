package aula11_tries_tabelassimbolos;

public class TabelaSimbolos<Chave, Valor> {
    private class Nodo {
        Chave chave;
        Valor valor;
        Nodo proximo;
        public Nodo(Chave chave, Valor valor, Nodo proximo) {
            this.chave = chave;
            this.valor = valor;
            this.proximo = proximo;
        }
    }
    private Nodo inicio;
    public void atualizar(Chave chave, Valor valor) {
        for (Nodo n = inicio;n!=null;n = n.proximo) {
            if(chave.equals(n.chave)) {
                n.valor = valor;
                return;
            }
        }
        Nodo novoNodo = new Nodo(chave, valor, inicio);
        inicio = novoNodo;
    }
    public Valor buscar(Chave chave) {
        for(Nodo n = inicio; n!=null; n=n.proximo) {
            if(chave.equals(n.chave)) return n.valor;
        }
        return null;
    }
    public void imprimir() {
        for(Nodo n=inicio;n!=null;n=n.proximo) {
            System.out.println(n.chave + " - " + n.valor);
        }
    }
    public boolean contem(Chave chave) {
        return (buscar(chave)!=null);
    }
    public boolean vazia() {
        return (inicio==null);
    }


}
