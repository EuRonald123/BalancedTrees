package Arquivos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Random;

public class Escrita {
    
    public void ecrever_no_arquivo(String nomeArquivo,int quantidade){
        String caminhoArquivo = "/home/ronald_popos/Programacao/ED2_atvd_pratica_2/ED2_INTERSECAO/src/Arquivos/";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo+nomeArquivo))){
            String linha;
            Random random = new Random();
            
            for(int i=0;i<quantidade;i++){
                int valorAleatorio = random.nextInt(quantidade);
                linha = Integer.toString(valorAleatorio);
                //escreve no arquivo
                escritor.write(linha+"\n");

            }

        } catch (Exception error) {
            System.out.println("\nNao foi possivel escrever no arquivo"+error.getMessage());
        }
    }
}
