import java.util.ArrayList;
import Arquivos.Leitura;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import HashTable.HashTentativaLinear;


public class Teste {
    private static final String ARQUIVO_1K = "1K_inteiros.txt";
    private static final String ARQUIVO_100K = "100K_inteiros.txt";
    private static final String ARQUIVO_1M = "1M_inteiros.txt";
    public static void main(String[] args) {
        //inicialização das bombas
        ArrayList<Integer> conjuntoA = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArvoreAVL<Integer> avl = new ArvoreAVL<>();
        RBtree<Integer> rb = new RBtree<>();
        HashTentativaLinear<Integer,Integer> hl = new HashTentativaLinear<>();
        Leitura ler = new Leitura();
        Controller funcoes = new Controller();


        //ler e armazenar nas estruturas
        ler.lerArquivo_e_armazenar(conjuntoA, ARQUIVO_1K);
        /*
         * Arquivo com menor quantidade de dados é o conjunto A que fica na Lista
         * Os outros arquivos são o conjunto B que pode ser avl, rb, hl ou lista
         */
        ler.lerArquivo_e_armazenar(arr, ARQUIVO_1M);
        ler.lerArquivo_e_armazenar(avl, ARQUIVO_1M);
        ler.lerArquivo_e_armazenar(rb, ARQUIVO_1M);
        ler.lerArquivo_e_armazenar(hl, ARQUIVO_1M);


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
        medirTempo(()->funcoes.Intersecao_A_B(conjuntoA, avl),"Intercesao_A_B");
        medirTempo(()->funcoes.Uniao_A_B(conjuntoA, avl),"Uniao_A_B");
        medirTempo(()->funcoes.Remove_elem_de_A_presentes_em_B(conjuntoA, avl),"Remove_elem...");
        //medirTempo(()->funcoes.Add_B_Uniao_A_B(conjuntoA,avl),"Add_B_Uniao_A_B");
        

        

        
    }
    private static void medirTempo(Runnable funcao,String nomeFuncao){
        long inicio = System.nanoTime();
        funcao.run();
        long fim = System.nanoTime();
        long tempoTotal = (fim - inicio)/1_000_000;
        System.out.println("Tempo de execucao "+ nomeFuncao+" é: "+tempoTotal+" ms");
    }
    
}
