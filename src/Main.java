/*Leia o README antes de funçar o código */


import java.util.ArrayList;
import java.util.Scanner;
import Arquivos.*;
import HashTable.HashTentativaLinear;
import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;


public class Main{
    private static final String ARQUIVO_1K = "1K_inteiros.txt";
    private static final String ARQUIVO_100K = "100K_inteiros.txt";
    private static final String ARQUIVO_1M = "1M_inteiros.txt";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean rodando =true;
        while(rodando){
            System.out.print("\n***MENU PRINCIPAL***\n");
            System.out.print("\nQual estrutura deseja usar:\n1 - ArrayList\n2 - TreeAVL\n3 - treeRB\n4 - HashLinear\n9 - SAIR\n");
            
            Leitura ler = new Leitura();
            String str;
            int opcao = scan.nextInt();
            ArrayList<Integer> A = new ArrayList<>();
            
            switch (opcao) {
                case 1:
                    ArrayList<Integer> arrayB = new ArrayList<>();

                    str = TamanhoArquivoString(scan);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(A, ARQUIVO_1K);
                        ler.lerArquivo_e_armazenar(arrayB, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                        break;
                    }

                    MenuAcoes(A,arrayB,scan);
                    break;

                case 2:
                    //ArrayList<Integer> A = new ArrayList<>();
                    ArvoreAVL<Integer> avlB = new ArvoreAVL<>();

                    str = TamanhoArquivoString(scan);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(A, ARQUIVO_1K);
                        ler.lerArquivo_e_armazenar(avlB, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                        break;
                    }

                    MenuAcoes(A,avlB,scan);
                    break;

                case 3:
                    //ArrayList<Integer> A = new ArrayList<>();
                    RBtree<Integer> RB_B = new RBtree<>();

                    str = TamanhoArquivoString(scan);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(A, ARQUIVO_1K);
                        ler.lerArquivo_e_armazenar(RB_B, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                        break;
                    }

                    MenuAcoes(A,RB_B,scan);
                    break;

                case 4:
                    //ArrayList<Integer> A = new ArrayList<>();
                    HashTentativaLinear<Integer,Integer> hashLinearB = new HashTentativaLinear<>();

                    str = TamanhoArquivoString(scan);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(A, ARQUIVO_1K);
                        ler.lerArquivo_e_armazenar(hashLinearB, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                        break;
                    }

                    MenuAcoes(A,hashLinearB,scan);
                    break;
                case 9:
                    System.out.println("\n SAINDO...");
                    rodando = false;
                    break;
            
                default:
                    break;
            }
        }
        scan.close();
    }


    private static String TamanhoArquivoString(Scanner scanner){
        System.out.print("\nSelecione o arquivo que deseja ler\n1 - '1K_inteiros.txt'(pequeno)\n2 - '100K_inteiros.txt'(medio)\n3 - '1M_inteiros.txt'(grande)\n9 - VOLTAR\n");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: return ARQUIVO_1K;
            case 2: return ARQUIVO_100K;
            case 3: return ARQUIVO_1M;
            case 9: return "";
            default:
                System.out.println("\nOpcao Invalida");
                return "";
        }
    }

    private static <T> void MenuAcoes(ArrayList<Integer> A,T B,Scanner scanner){
        Controller funcoes = new Controller();
        boolean rodando = true;
        String mensagem;
        while(rodando){
            System.out.print("\n***Menu de ações***\n");
            System.out.print("\nO que deseja fazer:\n1 - Buscar os elementos de A que estao em B (gera um arquivo txt)\n2 - Inserir em B, os elementos de A que não estao em B\n3 - Remover os elementos de A que estao em B(Nao gera um txt nem modifica os ja criados)\n");
            System.out.print("\nFuncoes adicionais\n4 - gerar arquivo txt com a Uniao de A com B(elementos de A que nao estao em B)\n");
            System.out.println("9 - Voltar");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                mensagem = "\nArquivo txt gerado com sucesso";
                    if(B instanceof ArrayList){
                        funcoes.Intersecao_A_B(A, (ArrayList<Integer>)B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof ArvoreAVL){
                        funcoes.Intersecao_A_B(A,(ArvoreAVL<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof RBtree){
                        funcoes.Intersecao_A_B(A,(RBtree<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else{
                        funcoes.Intersecao_A_B(A,(HashTentativaLinear<Integer,Integer>) B);
                        System.out.println(mensagem);
                    }
                    break;
                case 2:
                    if(B instanceof ArrayList){
                        funcoes.Add_B_Uniao_A_B(A,(ArrayList<Integer>) B);
                    }
                    else if(B instanceof ArvoreAVL){
                        funcoes.Add_B_Uniao_A_B(A,(ArvoreAVL<Integer>) B);
                    }
                    else if(B instanceof RBtree){
                        funcoes.Add_B_Uniao_A_B(A,(RBtree<Integer>) B);
                    }
                    else{
                        funcoes.Add_B_Uniao_A_B(A,(HashTentativaLinear<Integer,Integer>) B);
                    }
                    break;

                case 3:
                    mensagem = "\n Arquivo contendo a unicao de A com B gerado";
                    boolean verifica;
                    if(B instanceof ArrayList){
                        verifica =funcoes.Remove_elem_de_A_presentes_em_B(A,(ArrayList<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof ArvoreAVL){
                        verifica =funcoes.Remove_elem_de_A_presentes_em_B(A,(ArvoreAVL<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof RBtree){
                        verifica =funcoes.Remove_elem_de_A_presentes_em_B(A,(RBtree<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else{
                        verifica =funcoes.Remove_elem_de_A_presentes_em_B(A,(HashTentativaLinear<Integer,Integer>) B);
                        System.out.println(mensagem);
                    }

                    if(verifica){
                        System.out.println("\nRemovido de A, os elementos que estavam em B");
                    }
                    else{
                        System.out.println("\nFalha na remoção, tente novamente mais tarde.");
                    }
                    break;
                case 4:
                    mensagem = "\n Arquivo contendo a unicao de A com B gerado";
                    if(B instanceof ArrayList){
                        funcoes.Uniao_A_B(A,(ArrayList<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof ArvoreAVL){
                        funcoes.Uniao_A_B(A,(ArvoreAVL<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else if(B instanceof RBtree){
                        funcoes.Uniao_A_B(A,(RBtree<Integer>) B);
                        System.out.println(mensagem);
                    }
                    else{
                        funcoes.Uniao_A_B(A,(HashTentativaLinear<Integer,Integer>) B);
                        System.out.println(mensagem);
                    }
                    break;
                case 9:
                    System.out.println("\nVoltando ... ");
                    rodando=false;
                    break;
            
                default:
                    break;
            }
        }
    }
}
