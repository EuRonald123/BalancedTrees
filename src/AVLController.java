import java.util.ArrayList;
import TreeAVL.ArvoreAVL;
import Arquivos.*;

public class AVLController {
    Escrita escritor = new Escrita();

    //busca os elementos de A que estão em B e gera um arquivo;
    //cobrado da lista
    public void Intersecao_A_B(ArrayList<Integer> A,ArvoreAVL<Integer> B){
        boolean append = false;
        escritor.escrever("Intersecao_A_B", "***Elementos de A que estao em B***", append);
        append=true;
        
        for(int x:A){
            if(B.find(x)){
                escritor.ecrever_no_arquivo("Intersecao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo gera um arquivo com os elementos de A que nao estao em B
    //bom para testes
    public void Uniao_A_B(ArrayList<Integer> A,ArvoreAVL<Integer> B){
        boolean append = false;
        escritor.escrever("Uniao_A_B.txt", "***Elementos de A que nao estao em B***", append);
        append = true;
        for(int x:A){
            if(B.find(x)==false){
                //escrever em um arquivo
                escritor.ecrever_no_arquivo("Uniao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo apenas adiciona em B os elementos de A que nao estavam em B
    //cobrado da lista
    public void Add_B_Uniao_A_B(ArrayList<Integer> A,ArvoreAVL<Integer> B){
        for(int x:A){
            if(B.find(x)==false){
                B.insert(x);
            }
        }
    }
}
