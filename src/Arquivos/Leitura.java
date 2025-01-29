package Arquivos;

import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {

    //ler do arquivo e armazenar n treeAVL
    public void lerArquivo_e_armazenar_inteiros(ArvoreAVL<Integer> avlTree,String nomeArquivo){

        //separar por tipo, se for int pum, se for float , pam, se for caractere , pow


        String caminhoArquivo = "ED2_INTERSECAO/src/Arquivos/";//caminho do arquivo escolhido

        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo+nomeArquivo))){
            String linha;
            //pula a primeira linha
            reader.readLine();

            while((linha = reader.readLine()) != null){

                //para ignorar as linhas vazias no nosso caso, a ultima linha
                if(linha.trim().isEmpty()){
                    continue;
                }

                int valor = Integer.parseInt(linha);
                avlTree.insert(valor);
            }

        }catch(IOException error){
            System.out.println("Erro na leitura do arquivo" + error.getMessage());
        }
    }


    //ler do arquivo e armazenar na rubro negra
    public void lerArquivo_e_armazenar_inteiros(RBtree<Integer> RBtree,String nomeArquivo){


        String caminhoArquivo = "ED2_INTERSECAO/src/Arquivos/";//caminho do arquivo escolhido

        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo+nomeArquivo))){
            String linha;
            //para pular a primeira linha
            reader.readLine();
            while((linha = reader.readLine()) != null){

                //para ignorar as linhas vazias no nosso caso, a ultima linha
                if(linha.trim().isEmpty()){
                    continue;
                }

                int valor = Integer.parseInt(linha);
                RBtree.insert(valor);
            }

        }catch(IOException error){
            System.out.println("Erro na leitura do arquivo" + error.getMessage());
        }
    }



    public void lerArquivo_e_armazenar_inteiros(ArrayList<Integer> array,String nomeArquivo){


        String caminhoArquivo = "ED2_INTERSECAO/src/Arquivos/";//caminho do arquivo escolhido

        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo+nomeArquivo))){
            String linha;
            //para pular a primeira linha
            reader.readLine();
            while((linha = reader.readLine()) != null){

                //para ignorar as linhas vazias no nosso caso, a ultima linha
                if(linha.trim().isEmpty()){
                    continue;
                }

                int valor = Integer.parseInt(linha);
                array.add(valor);
            }

        }catch(IOException error){
            System.out.println("Erro na leitura do arquivo" + error.getMessage());
        }
    }


}
