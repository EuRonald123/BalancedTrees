import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import Arquivos.Leitura;

import java.util.ArrayList;

import Arquivos.Escrita;

public class teste2 {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		//inicializa as arvores
		ArvoreAVL<Integer> B = new ArvoreAVL<>();
		ArvoreAVL<Integer> C = new ArvoreAVL<>();
		RBtree<Integer> treeRB = new RBtree<>();


		Intersecao intersecao = new Intersecao();
		
		
		Leitura leitura = new Leitura();

		Escrita escritor = new Escrita();

		//escritor.ecrever_no_arquivo("teste", 10);
		
		
		//leitura.lerArquivo_e_armazenar_inteiros_treeRB(treeRB, "1.000.000_inteiros.txt");

		


		//int valorBuscado = 999967;
		//if(treeRB.find(valorBuscado)){
		//	System.out.println("\n valor buscado: "+valorBuscado+" esta presente na arvore");
		//}
		//else{
		//	System.out.println("\n"+valorBuscado+" nao esta na arvore");
		//}

		

		leitura.lerArquivo_e_armazenar_inteiros_ArrayList(A, "1000_inteiros.txt");
		leitura.lerArquivo_e_armazenar_inteiros_treeAVL(B, "100.000_inteiros.txt");
		leitura.lerArquivo_e_armazenar_inteiros_treeRB(treeRB, "1000_inteiros.txt");

		intersecao.buscar_elem_de_A_em_B_treeAVL(A, B, C);


		

		//System.out.println("\n***Elementos de A ***");
		//treeRB.printInOrder();
		//System.out.println("********************");

		System.out.println("\n*** Elementos de A que estão em B em ordem ***");
		C.printInOrder();
		System.out.println("********************");

	}
}