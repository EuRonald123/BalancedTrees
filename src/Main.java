import java.util.ArrayList;
import java.util.Scanner;
import Arquivos.*;


public class Main {
    private static final String ARQUIVO_1K = "1K_inteiros.txt";
    private static final String ARQUIVO_100K = "100K_inteiros.txt";
    private static final String ARQUIVO_1M = "1M_inteiros.txt";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean rodando =true;
        while(rodando){
            System.out.print("\n***MENU PRINCIPAL***\n");
            System.out.print("\nQual estrutura deseja usar:\n1 - ArrayList\n2 - TreeAVL\n3 - treeRB\n4 - HashLinear\n9 - SAIR\n");
            
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    ArrayList<Integer> arrayA = new ArrayList<>();
                    ArrayList<Integer> arrayB = new ArrayList<>();

                    Leitura ler = new Leitura();

                    String str = TamanhoArquivoString(scan);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(arrayA, ARQUIVO_1K);
                        ler.lerArquivo_e_armazenar(arrayB, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                    }

                    MenuAcoes(arrayA,arrayB,scan);
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

    private static void MenuAcoes(ArrayList<Integer> A,ArrayList<Integer> B,Scanner scanner){
        Controller funcoes = new Controller();
        boolean rodando = true;
        while(rodando){
            System.out.print("\n***Menu de ações***\n");
            System.out.print("\nO que deseja fazer:\n1 - Buscar os elementos de A que estao em B (gera um arquivo txt)\n2 - Inserir em B, os elementos de A que não estao em B\n3 - Remover os elementos de A que estao em B(Nao gera um txt nem modifica os ja criados)\n");
            System.out.print("\nFuncoes adicionais\n4 - gerar arquivo txt com a Uniao de A com B(elementos de A que nao estao em B)\n");
            System.out.println("9 - Voltar");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    funcoes.Intersecao_A_B(A, B);
                    System.out.println("\nArquivo txt gerado com sucesso");
                    break;
                case 2:
                    funcoes.Add_B_Uniao_A_B(A, B);
                    break;

                case 3:
                    boolean verifica;
                    verifica =funcoes.Remove_elem_de_A_presentes_em_B(A, B);
                    if(verifica){
                        System.out.println("\nRemovido de A, os elementos que estavam em B");
                    }
                    else{
                        System.out.println("\nFalha na remoção, tente novamente mais tarde.");
                    }
                    break;
                case 4:
                    funcoes.Uniao_A_B(A, B);
                    System.out.println("\n Arquivo contendo a unicao de A com B gerado");
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
