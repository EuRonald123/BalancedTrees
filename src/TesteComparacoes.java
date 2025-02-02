import java.util.ArrayList;
import Arquivos.Leitura;
import HashTable.HashTentativaLinear;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;

public class TesteComparacoes {
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



        ler.lerArquivo_e_armazenar(arr, ARQUIVO_1M);
        avl.resetComparacoes();
        ler.lerArquivo_e_armazenar(avl, ARQUIVO_1M);
        int comparacoesInsercaoAVL = avl.getComparacoes();
        rb.resetComparacoes();
        ler.lerArquivo_e_armazenar(rb, ARQUIVO_1M);
        int comparacoesInsercaoRB = rb.getComparacoes();
        ler.lerArquivo_e_armazenar(hl, ARQUIVO_1M);
    
        System.out.println("\n***Total Comparacoes insercao***");

        System.out.println("AVL: "+comparacoesInsercaoAVL);
        System.out.println("RubroNegra: "+comparacoesInsercaoRB);



        System.out.println("\n***Total Comparacoes insercao elemento X***");


        int x = 12345672;

        avl.resetComparacoes();
        avl.insert(x);
        comparacoesInsercaoAVL=avl.getComparacoes();
        System.out.println("AVL: "+comparacoesInsercaoAVL);

        rb.resetComparacoes();
        rb.insert(x);
        comparacoesInsercaoRB=rb.getComparacoes();
        System.out.println("RB: "+comparacoesInsercaoRB);
    


        System.out.println("\n***Total Comparacoes Busca elemento X***");

        x=23219;

        int comparacaoBusca;
        //avl
        avl.find(x);
        comparacaoBusca =  avl.getComparacoesFind();
        System.out.println("AVL: "+comparacaoBusca);

        //rb
        rb.find(x);
        comparacaoBusca =  rb.getComparacoesFindRB();
        System.out.println("RB: "+comparacaoBusca);
        
    
    }

    
}
