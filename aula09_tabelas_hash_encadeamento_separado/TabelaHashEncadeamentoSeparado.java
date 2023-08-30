package aula09_tabelas_hash_encadeamento_separado;

public class TabelaHashEncadeamentoSeparado {

    private int capacidade;
    private int quantidade; //quantidde de chaves
    private ListaDuplamenteEncadeada[] tabela;
    public TabelaHashEncadeamentoSeparado(int capacidade) {
        this.capacidade = capacidade;
        tabela = new ListaDuplamenteEncadeada[this.capacidade];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new ListaDuplamenteEncadeada();
        }
        this.quantidade = 0;
    }
    public void inserir(int chave) {
        int h = funcaoHash(chave);
        tabela[h].adicionar(chave);
        System.out.println("Chave inserida na posicao " + h);
    }

    private int funcaoHash(int chave) {
        return chave % this.capacidade;
    }


    public static void main(String[] args) {
        TabelaHashEncadeamentoSeparado hash = new TabelaHashEncadeamentoSeparado(5);

        hash.inserir(200);
        hash.inserir(444);
        hash.inserir(200);
    }
}
