import java.util.Arrays;

public class Hash {
    int[] tabela1; // Tabela de tamanho 10
    int[] tabela2; // Tabela de tamanho 100
    int[] tabela3; // Tabela de tamanho 1000

    public Hash() {
        tabela1 = new int[10];
        tabela2 = new int[100];
        tabela3 = new int[1000];

        // Inicializa as três tabelas com -1
        Arrays.fill(tabela1, -1);
        Arrays.fill(tabela2, -1);
        Arrays.fill(tabela3, -1);
    }

    private int h(int chave) { // hash por divisão
        return chave % 100;
    }

    private int h2(int chave, int tamanhoTabela) { // hash por multiplicação
        double valorFracionario = chave * 0.5 - Math.floor(chave * 0.5);
        return (int) (tamanhoTabela * valorFracionario);
    }

    public int tamanho(int[] tabela) {
        int count = 0;
        for(int element : tabela) {
            count++;
        }
        return count;
    }

    private int h3(int chave) { // não implementado ainda
        return 0;
    }

    private int r(int i) {
        return (i + 1) % 100; 
    }

    public int busca(int chave, int[] tabela) {
        int i = h(chave);
        while (tabela[i] != chave && tabela[i] != -1) {
            i = r(i);
        }
        if (tabela[i] == -1) {
            return -1;
        } else {
            return i;
        }
    }

    public void inserir(int chave, int[] tabela) {
        int i = h(chave);
        while (tabela[i] != -1) {
            i = r(i);
        }
        tabela[i] = chave;
    }

    public void exibirTabela(int[] tabela) {
        int count = tamanho(tabela);
        for (int i = 0; i < count; i++) { // Usando um loop para evitar length
            if (tabela[i] != -1) {
                System.out.println("Posição " + i + ": " + tabela[i]);
            }
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash();
        hash.inserir(2213312, hash.tabela2); // Corrigido para usar tabela2
        hash.inserir(2213317, hash.tabela2);
        hash.inserir(2213315, hash.tabela2);
        hash.inserir(2213314, hash.tabela2);
        hash.inserir(2213313, hash.tabela2);
        
        
        hash.exibirTabela(hash.tabela2);
    }
}
