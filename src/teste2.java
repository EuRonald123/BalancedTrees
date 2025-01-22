import TreeAVL.ArvoreAVL;
import TreeRB.RBtree;

public class teste2 {
	public static void main(String[] args) {
		ArvoreAVL<Integer> avlTree = new ArvoreAVL<>();
		ArvoreAVL<String> avlTreeString = new ArvoreAVL<>();
		RBtree<Integer> treeRB = new RBtree<>();
		
		int []vet= {46,27,20,15,10,90,98,95};
		for(int i=0;i<vet.length;i++) {
			avlTree.insert(vet[i]);
		}

		String []vetName= {"Ro","rona","ronal","ronald"};
		for(int i=0;i<vetName.length;i++) {
			avlTreeString.insert(vetName[i]);
		}

		//teste para arvore RB
		int []vetRB= {46,27,20,15,10,90,98,95};
		for(int i=0;i<vetRB.length;i++) {
			treeRB.insert(vetRB[i]);
		}


		treeRB.remove(20);


        System.out.println("\n***InOrder***\n");
		avlTree.printInOrder();
        System.out.println("\n**********************************************");
        System.out.println("\n***PosOrder***\n");
        avlTree.printPosOrder();

		
		boolean removido = avlTree.remove(10);
		if(removido){
			System.out.println("\n***Remocao foi um sucesso***\n");
		}else{
			System.out.println("\n***Elemento nao encontrado***\n");
		}

		System.out.println("\n**********************************************");
		System.out.println("\n***InOrder***\n");
		avlTree.printInOrder();
        System.out.println("\n**********************************************");
        System.out.println("\n***PosOrder***\n");
        avlTree.printPosOrder();


		System.out.println("\n*****************************\n");
		if(avlTree.find(90)){
			System.out.println("\n***TRUE***");
		}else{
			System.out.println("***FALSE***");
		}
	}
}