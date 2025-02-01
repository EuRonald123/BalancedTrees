import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import HashTable.HashTentativaLinear;
import Arquivos.*;

import java.util.ArrayList;

public class teste2 {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		//inicializa as arvores
		ArvoreAVL<Integer> B = new ArvoreAVL<>();
		//ArvoreAVL<Integer> C = new ArvoreAVL<>();

		HashTentativaLinear<Integer, Integer> C = new HashTentativaLinear<>();




		RBtree<Integer> D = new RBtree<>();



		Controller controller = new Controller();
		
		
		Leitura leitura = new Leitura();

		//
		leitura.lerArquivo_e_armazenar(A, "1K_inteiros.txt");
		leitura.lerArquivo_e_armazenar(D, "1M_inteiros.txt");
		leitura.lerArquivo_e_armazenar(B, "100K_inteiros.txt");
		//leitura.lerArquivo_e_armazenar(C, "nomes_aleatorios_1M.txt");

		

		controller.Intersecao_A_B(A, B);
		controller.Uniao_A_B(A, B);

		Escrita escrever = new Escrita();
		escrever.gerarInteiros("1M_inteiros.txt", 1000000);

		//controller.Add_B_Uniao_A_B(A, D);

		//D.printInOrder();
		
		//int altura = D.getHeight();
		//System.out.println("\nAltura: "+altura);
		
/*
		String valorBuscado = "561";
		if(D.find(valorBuscado)){
			System.out.println("\nvalor buscado: "+valorBuscado+" esta presente na arvore");
		}
		else{
			System.out.println("\n"+valorBuscado+" nao esta na arvore");
		}
			

		//controller.Remove_elem_de_A_presentes_em_B(A, D);


		for(String elem:A){
			if(elem.equals(valorBuscado)){
				System.out.println("\n"+elem+ " presente");
				break;
			}
		}
			*/

		
	}
}