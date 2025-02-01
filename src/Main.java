import java.util.ArrayList;
import java.util.Scanner;
import Arquivos.*;


public class Main {
    private static final String ARQUIVO_STRING_1K = "nomes_aleatorios_1K.txt";
    private static final String ARQUIVO_STRING_100K = "nomes_aleatorios_100K.txt";
    private static final String ARQUIVO_STRING_1M = "nomes_aleatorios_1M.txt";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean rodando =true;
        while(rodando){
            System.out.print("\n***MENU PRINCIPAL***\n");
            System.out.print("\nQual estrutura deseja usar:\n1 - ArrayList\n2 - TreeAVL\n3 - treeRB\n4 - HashLinear\n9 - SAIR\n");
            
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    MenuSelecaoTipo(scan);
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

    private static void MenuSelecaoTipo(Scanner scanner){
        boolean rodando =true;
        while(rodando){
            System.out.print("\n***Menu de Seleção***\n");
            System.out.print("\nDefina o tipo da estrutura selecionada\n1 - Inteiros\n2 - String/caractere\n9 - SAIR\n");
            int opcao = scanner.nextInt();
            String str;
            switch (opcao) {
                case 1:
                    
                    break;
                case 2:
                    //inicialização das bombas
                    ArrayList<String> arrayA = new ArrayList<>();
                    ArrayList<String> arrayB = new ArrayList<>();

                    Leitura ler = new Leitura();

                    str = TamanhoArquivoString(scanner);

                    if(str !=null && !str.isEmpty()){
                        ler.lerArquivo_e_armazenar(arrayA, ARQUIVO_STRING_1K);
                        ler.lerArquivo_e_armazenar(arrayB, str);
                    }else{
                        System.out.println("\nArquivo não encontrado");
                    }

                    MenuAcoes(arrayA,arrayB,scanner);

                    break;

                case 9: 
                    System.out.println("\nVoltando...");
                    rodando = false;
                    break;

                default:
                System.out.println("\nOpcao Invalida");
                    break;
            
            }
        }
    }

    private static String TamanhoArquivoString(Scanner scanner){
        System.out.print("\nSelecione o arquivo que deseja ler\n1 - 'nomes_aleatorios_1K.txt'(pequeno)\n2 - 'nomes_aleatorios_100K.txt'(medio)\n3 - 'nomes_aleatorios_1M.txt'(grande)\n9 - VOLTAR\n");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: return ARQUIVO_STRING_1K;
            case 2: return ARQUIVO_STRING_100K;
            case 3: return ARQUIVO_STRING_1M;
            case 9: return "";
            default:
                System.out.println("\nOpcao Invalida");
                return "";
        }
    }

    private static void MenuAcoes(ArrayList<String> A,ArrayList<String> B,Scanner scanner){
        Controller funcoes = new Controller();
        boolean rodando = true;
        while(rodando){
            System.out.print("\n***Menu de ações***\n");
            System.out.print("\nO que deseja fazer:\n1 - Buscar os elementos de A que estao em B (gera um arquivo txt)\n2 - Inserir em B, os elementos de A que não estao em B\n3 - Remover os elementos de A que estao em B\n");
            System.out.print("\nFuncoes adicionais\n4 - Gerar arquivo txt com a uniao A com B\n5 - gerar arquivo txt com a intersecao A com B\n 9 - MenuPrincipal\n");
            System.out.println("9 - Voltar");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    
                    break;
                case 2:

                    break;

                case 3:

                    break;
                case 4:
                    funcoes.Uniao_A_B(A, B);
                    System.out.println("\nArquivo txt gerado com sucesso");
                    break;
                case 5:

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
