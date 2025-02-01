import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import HashTable.HashTentativaLinear;
import Arquivos.*;

import java.util.ArrayList;

public class teste2 {
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
		//inicializa as arvores
		ArvoreAVL<String> B = new ArvoreAVL<>();
		//ArvoreAVL<Integer> C = new ArvoreAVL<>();

		HashTentativaLinear<String, String> C = new HashTentativaLinear<>();




		RBtree<String> D = new RBtree<>();



		Controller controller = new Controller();
		
		
		Leitura leitura = new Leitura();

		//
		leitura.lerArquivo_e_armazenar(A, "nomes_aleatorios_100K.txt");
		leitura.lerArquivo_e_armazenar(D, "nomes_aleatorios_1M.txt");
		leitura.lerArquivo_e_armazenar(B, "nomes_aleatorios_1M.txt");
		//leitura.lerArquivo_e_armazenar(C, "nomes_aleatorios_1M.txt");

		String name = "Kerry";
		if(C.contains(name)){
			System.out.println("\nnome: "+name+" esta presente no hashTentativaLinear");
		}

		controller.Intersecao_A_B(A, B);
		controller.Uniao_A_B(A, B);

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