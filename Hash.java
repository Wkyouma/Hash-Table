import java.util.Arrays;

public class Hash {
    private int[] tabela;
    private static final int TamanhoTabelaUm = 100;
    private static final int TamanhoTabelaDois = 1000;//os tres limites
    private static final int TamanhoTabelaTres = 10;
   
    public Hash() {
        tabela = new int[TamanhoTabelaDois];
        Arrays.fill(tabela, -1); // para inicializar a tabela com -1
    }


    private int h(int chave) {//hash por divisão
        return chave % 100;
    }

    private int h2(int chave, int tamanhoTabela){//hash por multiplicação
        double valorFracionario = chave * 0.5 - Math.floor(chave * 0.5);
        return (int) (tamanhoTabela * valorFracionario);
    }

    private int h3(int chave){//não implementado ainda
        return 0;
    }

    private int r(int i){
        return (i+1)%100;
    }

    public int busca(int chave){
        int i = h(chave);
        while(tabela[i]!=chave&&tabela[i]!= -1){
            i=r(i);
        }
            if(tabela[i]== -1){
                return -1;
            }else{
                return i;   
        }
    }

    public void inserir(int chave){
        int i = h(chave);
        while(tabela[i]!= -1){
            i=r(i);
        }
        tabela[i]=chave;
    }
    public void exibirTabela() {
        for (int i = 0; i < TamanhoTabelaDois; i++) {
            if (tabela[i] != -1) {
                System.out.println("Posição " + i + ": " + tabela[i]);
            }
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash();
        hash.inserir(2213312);
        hash.inserir(2213317);
        hash.inserir(2213315);
        hash.inserir(2213314);
        hash.inserir(2213313);
        hash.exibirTabela();
      
    }
}
