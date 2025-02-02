package TreeAVL;
import Interface.BalancedTree;


public class ArvoreAVL<T extends Comparable<T>> implements BalancedTree <T>{
	//para contar o numero de comparacoes no meu Find
	private int comparacoesFind=0;
	private int comparacoes = 0;


	private NoAVL<T> root;
	
	public ArvoreAVL(){
		this.root=null;
	}


	private int getHeight(NoAVL<T> node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	//balanced factor
	private int balanceFactor(NoAVL<T> node) {
		if(node == null) {
			return 0;
		}
		return (getHeight(node.right) - getHeight(node.left));
	}
	
	private void updateHeight(NoAVL<T> node) {
		int l = getHeight(node.left);
		int r = getHeight(node.right);
		node.height=Math.max(l, r)+1;
	}
	
	//simple left rotation
	private NoAVL<T> simpleLeftRotation(NoAVL<T> k1) {
		NoAVL<T> key = k1.right;
		k1.right = key.left;
		key.left = k1;
		updateHeight(k1);
		updateHeight(key);
		return key;
	}
	//simple right rotation
	private NoAVL<T> simpleRightRotation(NoAVL<T> k1) {
		NoAVL<T> key = k1.left;
		k1.left = key.right;
		key.right = k1;
		updateHeight(k1);
		updateHeight(key);
		return key;
	}
	
	//double rotation to the left
	private NoAVL<T> doubleLeftRotation(NoAVL<T> node){
		node.right = simpleRightRotation(node.right);
		return simpleLeftRotation(node);
	}
	//double rotation to the right
	private NoAVL<T> doubleRightRotation(NoAVL<T> node){
		node.left = simpleLeftRotation(node.left);
		return simpleRightRotation(node);
	}
	
	/**
	 * Fumcao para fazer o balanceamento da arvore
	 * @param t
	 * @return
	 */
	private NoAVL<T> balanceTree(NoAVL<T> t){
        updateHeight(t);
        int balance = balanceFactor(t);
        
		comparacoes++; //ou cai no if ou cai no elseIf

        if(balance < -1){
			comparacoes++;
            if(balanceFactor(t.left)>0){
                t = doubleRightRotation(t);
            }else{
                t = simpleRightRotation(t);
            }
        }else if(balance > 1){
			comparacoes++;
            if(balanceFactor(t.right)<0){
                t = doubleLeftRotation(t);
            }else{
                t = simpleLeftRotation(t);
            }
        }
		return t;
    }

	//insert avl
	//essa funcao era apenas um if else if e else if mas para comparacoes e testes tive que mudar
	private NoAVL<T> insert(NoAVL<T> t,T x) {
		comparacoes++;
		if(t == null) {
			return new NoAVL<>(x);
		}

		comparacoes++;
		if(x.compareTo(t.element)<0) {
			t.left = insert(t.left,x);
		}
		
		else {
			comparacoes++;
			if(x.compareTo(t.element)>0) {
				t.right = insert(t.right,x);
			}
		}

		return balanceTree(t);
	}
	
	private NoAVL<T> findMin(NoAVL<T> node){
		while(node.left != null) {
			comparacoes++;
			node = node.left;
		}
		return node;
	}
	
    private NoAVL<T> removeAVL(NoAVL<T> t,T x){
		//verifica se a raiz é nula.
		if(t==null) {
			return t;
		}
		if(x.compareTo(t.element)<0) {
			t.left=removeAVL(t.left,x);
		}
		else if(x.compareTo(t.element)>0) {
			t.right=removeAVL(t.right, x);
		}
		else {
			
			if(t.left == null && t.right == null) {
				//is sheet
				t = null;
				return null;
			}
			
			else if(t.left == null) {
				return t.right;
			}
			
			else if(t.right == null) {
				return t.left;
			}
			else {
				//has two childs
				NoAVL<T> temp = findMin(t.right);
				t.element = temp.element;
				t.right = removeAVL(t.right,t.element);
			}
		}
        return balanceTree(t);
		
	}
	
	
	private void printInOrder(NoAVL<T> node) {
		if(node == null) {
			System.out.println("\nNo nodes in the tree\n");
			return;
		}
		if(node.left != null) {
			printInOrder(node.left);
		}
		System.out.println(node.element + " ");
		if(node.right != null) {
			printInOrder(node.right);
		}
	}

    private void printPosOrder(NoAVL<T> node){
        if(node == null){
            System.out.println("\n No nodes in the tree\n");
            return;
        }
        if(node.left!=null){
            printPosOrder(node.left);
        }
        if(node.right!=null){
            printPosOrder(node.right);
        }
        System.out.println(node.element + "");
    }
    public void printPosOrder(){
        printPosOrder(root);
    }

	@Override
	public boolean find(T node){
		NoAVL<T> temp = root;
		comparacoesFind=0;
		while(temp!=null){
			comparacoesFind++;
			if(node.compareTo(temp.element)<0){
				temp = temp.left;
			}
			else if(node.compareTo(temp.element)>0){
				comparacoesFind++;
				temp = temp.right;
			}
			else{
				comparacoesFind++;//teve que ficar pois o minimo de comparacoes eh 2 e o max eh 3
				return true;
			}
		}
		return false;
	}


	/*
	private boolean find(NoAVL<T> t,T node){
		if(t!=null){
			comparacoesFind++;
			if(node.compareTo(t.element)<0){
				comparacoesFind++;
				return find(t.left,node);
			}
			else if(node.compareTo(t.element)>0){
				comparacoesFind++;
				return find(t.right,node);
			}
			else{
				return true;
			}
		}
		return false;
	}
	*/


	@Override
	public void insert(T x) {
		root = insert(root,x);
	}

	@Override
	public boolean remove(T x) {
		if(find(x)){
			root = removeAVL(root,x);
			return true;
		}
		return false;
		
	}

	//falta implementar
	

	@Override
	public int getHeight(){
		return getHeight(root);
	}

	@Override
	public void printInOrder() {
		printInOrder(root);
	}


	/**
	 * para comparacoes criei essas funcoes aqui
	 */

	public int getComparacoesFind(){
		return comparacoesFind;
	}

	public int getComparacoes(){
		return comparacoes;
	}

	public void resetComparacoes(){
		comparacoes=0;
	}
	
}