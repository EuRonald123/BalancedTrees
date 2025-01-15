public class teste2 {
	public static void main(String[] args) {
		ArvoreAVL<Integer> avlTree = new ArvoreAVL<>();
		
		int []vet= {13,14,24,23,22,17,18,19};
		for(int i=0;i<vet.length;i++) {
			avlTree.insert(vet[i]);
		}
		
        System.out.println("\n***InOrder***\n");
		avlTree.printInOrder();
        System.out.println("\n**********************************************");
        System.out.println("\n***PosOrder***\n");
        avlTree.printPosOrder();

		
		boolean removido = avlTree.remove(19);
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
		if(avlTree.find(19)){
			System.out.println("\n***TRUE***");
		}else{
			System.out.println("***FALSE***");
		}
	}
	
}