

class No {
    int chave;
    No proximo;

    public No(int chave) {
        this.chave = chave;
        this.proximo = null;
    }
}

public class Hash {
    No[] tabela1;
    No[] tabela2;
    No[] tabela3;
    int tamanhoTabela1 = 10;
    int tamanhoTabela2 = 10000;
    int tamanhoTabela3 = 1000;

    public Hash() {
        tabela1 = new No[tamanhoTabela1];
        tabela2 = new No[tamanhoTabela2];
        tabela3 = new No[tamanhoTabela3];
    }

    private int h(int tipo,int chave, int tamanhoTabela) { 
        if(tipo == 1){
            return chave % tamanhoTabela;//primeiro tipo de hash
        }
        else if(tipo == 2){
            double valorFracionario = chave * 0.5 - Math.floor(chave * 0.5);//segundo tipo de hash
            return (int) (tamanhoTabela * valorFracionario);
        }
        else if(tipo==3){
            //inserir terceiro tipo de hash
        }
        return -1; 
    }

   

    public void inserir(int tipo,int chave, No[] tabela, int tamanhoTabela) {
        int i = h(tipo,chave, tamanhoTabela);
        No novo = new No(chave);
        if (tabela[i] == null) {
            tabela[i] = novo;
        } else { 
            No atual = tabela[i];
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void exibirTabela(No[] tabela, int tamanhoTabela) {
        for (int i = 0; i < tamanhoTabela; i++) {
            No atual = tabela[i];
            System.out.print("Posição " + i + ":");
            while (atual != null) {
                System.out.print("-> "+atual.chave);
                atual = atual.proximo;
            }
            System.out.println("");
        }
    }

    public void inserirVarios( int tipo,int numero, No[] tabela, int tamanhoTabela) {
        for (int i = 0; i < numero; i++) {
            int chave = (int) (Math.random() * 1000000) + 1;
            inserir(tipo,chave, tabela, tamanhoTabela);
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash();

        hash.inserirVarios(1 , 1000, hash.tabela3, hash.tamanhoTabela3); 
        hash.exibirTabela(hash.tabela3, hash.tamanhoTabela3); 
    }
}
