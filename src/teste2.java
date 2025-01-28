import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;
import Arquivos.Leitura;
import Arquivos.Escrita;

public class teste2 {
	public static void main(String[] args) {
		ArvoreAVL<Integer> avlTree = new ArvoreAVL<>();
		ArvoreAVL<String> avlTreeString = new ArvoreAVL<>();
		RBtree<Integer> treeRB = new RBtree<>();
		
		Leitura leitura = new Leitura();

		Escrita escritor = new Escrita();
		escritor.ecrever_no_arquivo("1.000.000_inteiros.txt",1000000);
		
		leitura.lerArquivo_e_armazenar_AVL(avlTree);

		System.out.println("\n*** Em ordem ***");
		avlTree.printInOrder();
		System.out.println("********************");
	}
}