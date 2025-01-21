import TreeAVL.ArvoreAVL;


public class teste2 {
	public static void main(String[] args) {
		ArvoreAVL<Integer> avlTree = new ArvoreAVL<>();
		ArvoreAVL<String> avlTreeString = new ArvoreAVL<>();
		
		int []vet= {46,27,20,15,10,90,98,95};
		for(int i=0;i<vet.length;i++) {
			avlTree.insert(vet[i]);
		}

		String []vetName= {"Ro","rona","ronal","ronald","peituda"};
		for(int i=0;i<vetName.length;i++) {
			avlTreeString.insert(vetName[i]);
		}
		
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




		System.out.println("\n**********************************************");
		System.out.println("\n***InOrder***\n");
		avlTreeString.printInOrder();
		System.out.println("\n**********************************************");
		System.out.println("\n***PosOrder***\n");
		avlTreeString.printPosOrder();

		avlTreeString.remove("peituda");

		System.out.println("\n*****************************\n");
		if(avlTreeString.find("peituda")){
			System.out.println("\n***TRUE***");
		}else{
			System.out.println("***FALSE***");
		}


		System.out.println("\n**********************************************");
		System.out.println("\n***InOrder***\n");
		avlTreeString.printInOrder();
		System.out.println("\n**********************************************");
		System.out.println("\n***PosOrder***\n");
		avlTreeString.printPosOrder();
	}
}