import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import Arquivos.*;

import java.util.ArrayList;

public class teste2 {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		//inicializa as arvores
		ArvoreAVL<Integer> B = new ArvoreAVL<>();
		//ArvoreAVL<Integer> C = new ArvoreAVL<>();
		RBtree<Integer> D = new RBtree<>();


		Controller controller = new Controller();
		
		
		Leitura leitura = new Leitura();

		//Escrita escritor = new Escrita();

		//escritor.gerarInteiros("teste", 10);
		
		
		//leitura.lerArquivo_e_armazenar_inteiros(treeRB, "1.000.000_inteiros.txt");


		

		leitura.lerArquivo_e_armazenar_inteiros(A, "1000_inteiros.txt");
		leitura.lerArquivo_e_armazenar_inteiros(B, "100.000_inteiros.txt");
		//leitura.lerArquivo_e_armazenar_inteiros(D, "1.000.000_inteiros.txt");

		controller.Intersecao_A_B(A, B);
		controller.Uniao_A_B(A, B);

		int valorBuscado = 460;
		if(B.find(valorBuscado)){
			System.out.println("\n valor buscado: "+valorBuscado+" esta presente na arvore");
		}
		else{
			System.out.println("\n"+valorBuscado+" nao esta na arvore");
		}

		controller.Remove_elem_de_A_presentes_em_B(A, B);


		for(int elem:A){
			if(elem == 889){
				System.out.println("\n"+elem+ " presente");
				break;
			}
		}
	}
}