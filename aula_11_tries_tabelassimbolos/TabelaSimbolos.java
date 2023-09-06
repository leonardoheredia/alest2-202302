package aula_11_tries_tabelassimbolos;

public class TabelaSimbolos<Chave, Valor> {
    private class Nodo {
        private Chave chave;
        private Valor valor;
        private Nodo proximo;
        public Nodo(Chave chave, Valor valor, Nodo proximo) {
            this.chave = chave;
            this.valor = valor;
            this.proximo = proximo;
        }


    }
    private Nodo inicio;
    public void atualizar(Chave chave, Valor valor) {
        for (Nodo n=inicio; n!=null; n=n.proximo) {
            if(chave.equals(n.chave)) {
                n.valor = valor;
                return;
            }
        }
        Nodo novo = new Nodo(chave, valor, this.inicio);
        inicio = novo;
    }
    public boolean contem(Chave chave) {
        return buscar(chave)!=null;
    }
    public Valor buscar(Chave chave) {
        for(Nodo n=inicio; n!=null; n = n.proximo) {
            if(chave.equals(n.chave)) return n.valor;
        }
        return null;
    }
    @Override
    public String toString() {
        String str="";
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            str = str + n.chave.toString() + " " + n.valor.toString() + "\n";
        }
        return str;
    }

}
