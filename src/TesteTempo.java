import java.util.ArrayList;
import Arquivos.Leitura;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import HashTable.HashTentativaLinear;


public class TesteTempo {
    private static final String ARQUIVO_1K = "1K_inteiros.txt";
    private static final String ARQUIVO_100K = "100K_inteiros.txt";
    private static final String ARQUIVO_1M = "1M_inteiros.txt";
    public static void main(String[] args) {
        //inicialização das bombas
        ArrayList<Integer> conjuntoA = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArvoreAVL<Integer> avl = new ArvoreAVL<>();
        RBtree<Integer> rb = new RBtree<>();
        HashTentativaLinear<Integer,Integer> hl = new HashTentativaLinear<>(500000);
        Leitura ler = new Leitura();
        Controller funcoes = new Controller();


        //ler e armazenar nas estruturas
        ler.lerArquivo_e_armazenar(conjuntoA, ARQUIVO_1K);
        /*
         * Arquivo com menor quantidade de dados é o conjunto A que fica na Lista
         * Os outros arquivos são o conjunto B que pode ser avl, rb, hl ou lista
         */
        System.out.println("\n***Tempo de ler e armazenar na estrutura***");
        medirTempo(()->ler.lerArquivo_e_armazenar(arr, ARQUIVO_1M),"lerArq e armazenar no ARRAY");
        medirTempo(()->ler.lerArquivo_e_armazenar(avl, ARQUIVO_1M),"lerArq e armazenar no AVL");
        medirTempo(()->ler.lerArquivo_e_armazenar(rb, ARQUIVO_1M),"lerArq e armazenar no RubroNegra");
        medirTempo(()->ler.lerArquivo_e_armazenar(hl, ARQUIVO_1M),"lerArq e armazenar no HashLinear");


        System.out.println("\n***Tempo de Busca***");
        //Tempo de inserção de um valor aleatorio em cada estrutura individual
        //obs: ja verifiquei e esse elemento esta em todas as estruturas
        int valor = 702451;
        medirTempo(()->arr.contains(valor),"busca na ArrayLst");
        medirTempo(()->avl.find(valor),"busca na avl");
        medirTempo(()->rb.find(valor),"busca na rb");
        medirTempo(()->hl.contains(valor),"busca na hashLinear");



        System.out.println("\n***Tempo de Insercoes de um elemento X em cada estrutura***");
        int x = 123456;
        //inserções individuais

        medirTempo(()->arr.add(x),"Insercao arr");
        if(arr.contains(x)){
            System.out.println("AQUI "+x);
        }

        medirTempo(()->avl.insert(x),"Insercao avl");
        if(avl.find(x)){
            System.out.println("AQUI "+x);
        }

        medirTempo(()->rb.insert(x),"Insercao RB");
        if(rb.find(x)){
            System.out.println("AQUI "+x);
        }

        medirTempo(()->hl.put(x,x),"Insercao hashLinear");
        if(hl.contains(x)){
            System.out.println("AQUI "+x);
        }


        System.out.println("\n***Tempo de Remocao de um elemento X em cada estrutura***");
        //inserções individuais

        // fiz essa guambiarra pq não coloquei a condição de não inserir repetidos na lista, então essa guambiarra remove todos os elementos iguais a x
        medirTempo(()->arr.removeIf(n->n==x),"Remocao arrayList"); 
        if(arr.contains(x)){
            System.out.println("AQUI "+x);
        }


        medirTempo(()->avl.remove(x),"Remocao avl");
        if(avl.find(x)){
            System.out.println("AQUI "+x);
        }

        medirTempo(()->rb.remove(x),"Remocao RB");
        if(rb.find(x)){
            System.out.println("AQUI "+x);
        }

        medirTempo(()->hl.delete(x),"Remocao hashLinear");
        if(hl.contains(x)){
            System.out.println("AQUI "+x);
        }



        

        

        /*
         * funcoes implementadas cobradas:
         * Buscar os elementos de A que estão em B
         * Inserir em B, os elementos que estão em A mas não estão em B
         * Remover os elementos de A que estão em B
        */

        /*
         * Testes de tempo de execucao
         * para testar com diferentes estruturas, basta trocar o conjunto B pois o conjunto A sempre irá ser armazenado em uma Lista assim como foi solicitado
         */

        /*
        medirTempo(()->funcoes.Intersecao_A_B(conjuntoA, arr),"Intercesao_A_B");
        //medirTempo(()->funcoes.Uniao_A_B(conjuntoA, arr),"Uniao_A_B");//essa funcao não foi solicitada criei para testes
        medirTempo(()->funcoes.Remove_elem_de_A_presentes_em_B(conjuntoA, arr),"Remove_elem...");
        medirTempo(()->funcoes.Add_B_Uniao_A_B(conjuntoA,arr),"Add_B_Uniao_A_B");
        */

        

        
    }
    private static void medirTempo(Runnable funcao,String nomeFuncao){
        long inicio = System.nanoTime();
        funcao.run();
        long fim = System.nanoTime();
        long tempoTotal = (fim - inicio)/1_000;
        System.out.println("Tempo de execucao "+ nomeFuncao+" é: "+tempoTotal+" ns");
    }
    
}
