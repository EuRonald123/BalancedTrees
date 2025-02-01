package Arquivos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Random;

public class Escrita {
    
    public void gerarInteiros(String nomeArquivo,int quantidade){
        String caminhoArquivo = "ED2_INTERSECAO/src/Arquivos/";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo+nomeArquivo))){
            
            String linha;

            //para poder gerar numeros aleatorios
            Random random = new Random();
            
            for(int i=0;i<quantidade;i++){
                int valorAleatorio = random.nextInt(quantidade);
                linha = Integer.toString(valorAleatorio);
                //escreve no arquivo
                escritor.write(linha+"\n");

            }

        } catch (IOException error) {
            System.out.println("\nNao foi possivel escrever no arquivo"+error.getMessage());
        }
    }

    public void ecrever_no_arquivo(String nomeArquivo,String elemento,boolean append){
        String caminhoArquivo = "ED2_INTERSECAO/src/";
        //boolean append = true;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo+nomeArquivo,append))){
            //String linha;

            //linha = Integer.toString(elemento);
            escritor.write(elemento + "\n");

        } catch (IOException error) {
            System.out.println("\nNao foi possivel escrever no arquivo"+error.getMessage());
        }
    }

    public void ecrever_no_arquivo(String nomeArquivo,int elemento,boolean append){
        String caminhoArquivo = "ED2_INTERSECAO/src/";
        //boolean append = true;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo+nomeArquivo,append))){
            //String linha;

            //linha = Integer.toString(elemento);
            escritor.write(elemento + "\n");

        } catch (IOException error) {
            System.out.println("\nNao foi possivel escrever no arquivo"+error.getMessage());
        }
    }

    public void escrever(String nomeArquivo, String mensagem, boolean append){
        String caminhoArquivo = "ED2_INTERSECAO/src/";
        //boolean append = true;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo+nomeArquivo,append))){

            escritor.write(mensagem + "\n");

        } catch (IOException error) {
            System.out.println("\nNao foi possivel escrever no arquivo"+error.getMessage());
        }
    }
}
