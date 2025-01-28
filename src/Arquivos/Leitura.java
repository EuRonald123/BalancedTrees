package Arquivos;

import TreeAVL.ArvoreAVL;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura {


    public void lerArquivo_e_armazenar_AVL(ArvoreAVL<Integer> avlTree){

        //separar por tipo, se for int pum, se for float , pam, se for caractere , pow


        String caminhoArquivo = "ED2_INTERSECAO/src/Arquivos/1_milhao_inteiros.txt";//caminho do arquivo escolhido

        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))){
            String linha;
            while((linha = reader.readLine()) != null){
                int valor = Integer.parseInt(linha);
                avlTree.insert(valor);
            }

        }catch(IOException error){
            System.out.println("Erro na leitura do arquivo" + error.getMessage());
        }
    }
}
