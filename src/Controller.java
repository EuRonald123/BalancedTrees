import java.util.ArrayList;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import Arquivos.*;
import HashTable.HashTentativaLinear;

public class Controller {
    Escrita escritor = new Escrita();
    /**
     * Busca os elementos de A que estao em B e gera um arquivo com o nome Intersecao_A_B.txt
     * @param A
     * @param B
     * @return arquivo Intersecao_A_B.txt 
     * local ED2_INTERSECAO/src/
     */
    public void Intersecao_A_B(ArrayList<Integer> A,ArvoreAVL<Integer> B){
        boolean append = false;
        escritor.escrever("Intersecao_A_B.txt", "***Elementos de A que estao em B***", append);
        append=true;
        
        for(int x:A){
            if(B.find(x)){
                escritor.ecrever_no_arquivo("Intersecao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo gera um arquivo com os elementos de A que nao estao em B
    //bom para testes
    /**
     * Gera um arquivo com a Uniao de A com B, ou seja, elementos que estao em A mas não em B
     * @param A
     * @param B
     * @return Arquivo Uniao_A_B.txt  local  ED2_INTERSECAO/src
     */
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
    /**
     * Adiciona em B os elementos de A que nao estavam em B
     * @param A
     * @param B
     * @OBS Nao retorna nada e nao altera os arquivos ja existentes
     */
    public void Add_B_Uniao_A_B(ArrayList<Integer> A,ArvoreAVL<Integer> B){
        for(int x:A){
            if(B.find(x)==false){
                B.insert(x);
            }
        }
    }

    //método para remover os elementos de A que estão presentes em B;
    //cobrado da lista
    /**
     * Remove elementos de A que estao em B
     * @param A
     * @param B
     * @return retorna boolean e nao altera os arquivos ja existentes ou modifica eles
     */
    public boolean Remove_elem_de_A_presentes_em_B(ArrayList<Integer> A, ArvoreAVL<Integer> B){

        /*essa funcao removeIF remove de um ArrayList se cumprir uma condição
        Nesse caso para cada elemento de A se B.find(elementoDeA)==true então remove*/
        if(A.removeIf(B::find)){
            return true;
        }
        return false;
    }



    /*********************************************************************************************/
    
    /*ARVORE RUBRO NEGRA*/

    //busca os elementos de A que estão em B e gera um arquivo;
    //cobrado da lista
    /**
     * Busca os elementos de A que estao em B e gera um arquivo com o nome Intersecao_A_B.txt
     * @param A
     * @param B
     * @return arquivo Intersecao_A_B.txt 
     * local ED2_INTERSECAO/src/
     */
    public void Intersecao_A_B(ArrayList<Integer> A,RBtree<Integer> B){
        boolean append = false;
        escritor.escrever("Intersecao_A_B.txt", "***Elementos de A que estao em B***", append);
        append=true;
        
        for(int x:A){
            if(B.find(x)){
                escritor.ecrever_no_arquivo("Intersecao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo gera um arquivo com os elementos de A que nao estao em B
    //bom para testes
    /**
     * Gera um arquivo com a Uniao de A com B, ou seja, elementos que estao em A mas não em B
     * @param A
     * @param B
     * @return Arquivo Uniao_A_B.txt  local  ED2_INTERSECAO/src
     */
    public void Uniao_A_B(ArrayList<Integer> A,RBtree<Integer> B){
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
    /**
     * Adiciona em B os elementos de A que nao estavam em B
     * @param A
     * @param B
     * Nao retorna nada e nao altera os arquivos ja existentes
     */
    public void Add_B_Uniao_A_B(ArrayList<Integer> A,RBtree<Integer> B){
        for(int x:A){
            if(B.find(x)==false){
                B.insert(x);
            }
        }
    }

    //método para remover os elementos de A que estão presentes em B;
    //cobrado da lista
    /**
     * Remove elementos de A que estao em B
     * @param A
     * @param B
     * @return retorna boolean e nao altera os arquivos ja existentes ou modifica eles
     */
    public boolean Remove_elem_de_A_presentes_em_B(ArrayList<Integer> A, RBtree<Integer> B){
        /*essa funcao removeIF remove de um ArrayList se cumprir uma condição
        Nesse caso para cada elemento de A se B.find(elementoDeA)==true então remove
        Não foi possível aplicar aquela remoção padrão percorrendo todos os elementos*/
        if(A.removeIf(B::find)){
            return true;
        }
        return false;
    }


    

    //busca os elementos de A que estão em B e gera um arquivo;
    //cobrado da lista
    /**
     * Busca os elementos de A que estao em B e gera um arquivo com o nome Intersecao_A_B.txt
     * @param A
     * @param B
     * @return arquivo Intersecao_A_B.txt 
     * local ED2_INTERSECAO/src/
     */
    public void Intersecao_A_B(ArrayList<Integer> A,HashTentativaLinear<Integer,Integer> B){
        boolean append = false;
        escritor.escrever("Intersecao_A_B.txt", "***Elementos de A que estao em B***", append);
        append=true;
        
        for(int x:A){
            if(B.contains(x)){
                escritor.ecrever_no_arquivo("Intersecao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo gera um arquivo com os elementos de A que nao estao em B
    //bom para testes
    /**
     * Gera um arquivo com a Uniao de A com B, ou seja, elementos que estao em A mas não em B
     * @param A
     * @param B
     * @return Arquivo Uniao_A_B.txt  local  ED2_INTERSECAO/src
     */
    public void Uniao_A_B(ArrayList<Integer> A,HashTentativaLinear<Integer,Integer> B){
        boolean append = false;
        escritor.escrever("Uniao_A_B.txt", "***Elementos de A que nao estao em B***", append);
        append = true;
        for(int x:A){
            if(B.contains(x)==false){
                //escrever em um arquivo
                escritor.ecrever_no_arquivo("Uniao_A_B.txt", x,append);
            }
        }
    }
    /**
     * Adiciona em B os elementos de A que nao estavam em B
     * @param A
     * @param B
     * Nao retorna nada e nao altera os arquivos ja existentes
     */
    //cobrado da lista
    public void Add_B_Uniao_A_B(ArrayList<Integer> A,HashTentativaLinear<Integer,Integer> B){
        for(int x:A){
            if(B.contains(x)==false){
                B.put(x, x);
            }
        }
    }

    /**
     * método para remover os elementos de A que estão presentes em B;
     * cobrado da lista
     * @param A
     * @param B
     */
    
    public boolean Remove_elem_de_A_presentes_em_B(ArrayList<Integer> A, HashTentativaLinear<Integer,Integer> B){
        /*essa funcao removeIF remove de um ArrayList se cumprir uma condição
        Nesse caso para cada elemento de A se B.find(elementoDeA)==true então remove
        Não foi possível aplicar aquela remoção padrão percorrendo todos os elementos*/
        if(A.removeIf(B::contains)){
            return true;
        }
        return false;
    }

    /*********************************************************************************************/
    //busca os elementos de A que estão em B e gera um arquivo;
    //cobrado da lista
    /**
     * Busca os elementos de A que estao em B e gera um arquivo com o nome Intersecao_A_B.txt
     * @param A
     * @param B
     * @return arquivo Intersecao_A_B.txt 
     * local ED2_INTERSECAO/src/
     */
    public void Intersecao_A_B(ArrayList<Integer> A,ArrayList<Integer> B){
        boolean append = false;
        escritor.escrever("Intersecao_A_B.txt", "***Elementos de A que estao em B***", append);
        append=true;
        
        for(int x:A){
            if(B.contains(x)){
                escritor.ecrever_no_arquivo("Intersecao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo gera um arquivo com os elementos de A que nao estao em B
    //bom para testes
    /**
     * Gera um arquivo com a Uniao de A com B, ou seja, elementos que estao em A mas não em B
     * @param A
     * @param B
     * @return Arquivo Uniao_A_B.txt  local  ED2_INTERSECAO/src
     */
    public void Uniao_A_B(ArrayList<Integer> A,ArrayList<Integer> B){
        boolean append = false;
        escritor.escrever("Uniao_A_B.txt", "***Elementos de A que nao estao em B***", append);
        append = true;
        for(int x:A){
            if(B.contains(x)==false){
                //escrever em um arquivo
                escritor.ecrever_no_arquivo("Uniao_A_B.txt", x,append);
            }
        }
    }

    //esse metodo apenas adiciona em B os elementos de A que nao estavam em B
    //cobrado da lista
    /**
     * Adiciona em B os elementos de A que nao estavam em B
     * @param A
     * @param B
     * Nao retorna nada e nao altera os arquivos ja existentes
     */
    public void Add_B_Uniao_A_B(ArrayList<Integer> A,ArrayList<Integer> B){
        for(int x:A){
            if(B.contains(x)==false){
                B.add(x);
            }
        }
    }

    //método para remover os elementos de A que estão presentes em B;
    //cobrado da lista
    /**
     * Remove elementos de A que estao em B
     * @param A
     * @param B
     * @return retorna boolean e nao altera os arquivos ja existentes ou modifica eles
     */
    public boolean Remove_elem_de_A_presentes_em_B(ArrayList<Integer> A, ArrayList<Integer> B){

        /*essa funcao removeIF remove de um ArrayList se cumprir uma condição
        Nesse caso para cada elemento de A se B.find(elementoDeA)==true então remove*/
        if(A.removeIf(B::contains)){
            return true;
        }
        return false;
    }
    
}
