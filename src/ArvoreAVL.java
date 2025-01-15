public class ArvoreAVL<T extends Comparable<T>> implements BalancedTree <T>{
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
	
	private NoAVL<T> balanceTree(NoAVL<T> t){
        updateHeight(t);
        int balance = balanceFactor(t);
        
        if(balance < -1){
            if(balanceFactor(t.left)>0){
                t = doubleRightRotation(t);
            }else{
                t = simpleRightRotation(t);
            }
        }else if(balance > 1){
            if(balanceFactor(t.right)<0){
                t = doubleLeftRotation(t);
            }else{
                t = simpleLeftRotation(t);
            }
        }
		return t;
    }

	//insert avl
	private NoAVL<T> insert(NoAVL<T> t,T x) {
		if(t == null) {
			return new NoAVL<>(x);
		}
		
		else if(x.compareTo(t.element)<0) {
			t.left = insert(t.left,x);
		}
		
		else if(x.compareTo(t.element)>0) {
			t.right = insert(t.right,x);
		}

		return balanceTree(t);
	}
	
	private NoAVL<T> findMin(NoAVL<T> node){
		while(node.left != null) {
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

	private boolean find(NoAVL<T> t,T node){
		if(t!=null){
			if(node.compareTo(t.element)==0){
				return true;
			}
			if(node.compareTo(t.element)<0){
				return find(t.left,node);
			}
			else{
				return find(t.right,node);
			}
		}
		return false;
	}

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
	public boolean find(T node){
		return find(root, node);
	}

	@Override
	public int getHeight(){
		return getHeight(root);
	}

	@Override
	public void printInOrder() {
		printInOrder(root);
	}
	
}