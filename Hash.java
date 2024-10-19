import java.util.Random;

public class Hash {
    private Random random;
    Node[] tabela1;
    Node[] tabela2;
    Node[] tabela3;
    int tamanhoTabela1 = 100000;
    int tamanhoTabela2 = 10000;
    int tamanhoTabela3 = 1000;
    
    public Hash(long seed) {
        this.random = new Random(seed);
        tabela1 = new Node[tamanhoTabela1];
        tabela2 = new Node[tamanhoTabela2];
        tabela3 = new Node[tamanhoTabela3];
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
            //implementar terceiro tipo de hash
        }
        return -1; 
    }

   


    public void exibirTabela(Node[] tabela, int tamanhoTabela) {
        for (int i = 0; i < tamanhoTabela; i++) {
            Node atual = tabela[i];
            System.out.println("----------------------------------------------------------------");
            System.out.print("Posição " + i + ":");
            while (atual != null) {
                System.out.print("-> "+atual.chave);
                atual = atual.proximo;
            }
            System.out.println("");
        }
    }
    public void buscar(Node[] tabela, int chave, int tipo, int tamanhoTabela){
       //implementar
    }


    public void inserirVarios(int tipoH, int tipoR, int numero, Node[] tabela, int tamanhoTabela) {
        for (int i = 0; i < numero; i++) {
            int chave = random.nextInt(100000000) + 1;
            int a = h(tipoH, chave, tamanhoTabela);
            
            Node novo = new Node(chave);
    
            if (tipoR == 1) { // Encadeamento
                if (tabela[a] == null) {
                    tabela[a] = novo;
                } else { 
                    Node atual = tabela[a];
                    while (atual.proximo != null) {
                        atual = atual.proximo;
                    }
                    atual.proximo = novo;
                }
            } else if (tipoR == 2) {// rehasing simples
                while (tabela[a] != null) {
                    a = (a + 1) % tamanhoTabela;
                }
                tabela[a] = novo;
            }
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(21);//inserir semente para testes

        hash.inserirVarios(1 ,2, 9000, hash.tabela2, hash.tamanhoTabela2); 
        hash.exibirTabela(hash.tabela2, hash.tamanhoTabela2); 
        //tipoH é o tipo de hase que deseja 1 para divisão, 2 para multiplicação e 3 para...
        //tipoR é o tipo de tratamento de colisão que deseja 1 para encadeamento e 2 para rehashing linear
        //numero é o número de elementos a serem inseridos
        //tabela é a tabela hash que deseja manipular
        //tamanhoTabela é Tamanho da tabela 1 para 100000 2 para 10000 e 3 para 1000
    }
}
