import java.util.ArrayList;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;

public class Intersecao {

    //busca os elementos de A que estão em B;
    public void buscar_elem_de_A_em_B_treeAVL(ArrayList<Integer> A,ArvoreAVL<Integer> B, ArvoreAVL<Integer> C){
        for(int x:A){
            //int x = A.get(i);
            if(B.find(x)){
                C.insert(x);
            }
        }
    }

    public void inserir_em_B_que_nao_estao_em_A(){
        
    }
}
