package TreeRB;
import Interface.BalancedTree;
import TreeRB.NodeRB.Color;

public class RBtree<T extends Comparable<T>> implements BalancedTree<T>{
    private int comparacoesFindRB;
    private int comparacoes;

    private final NodeRB<T> nil = new NodeRB<>(null);

    private NodeRB<T> root;
    
    public RBtree(){
        this.root=nil;
        nil.parent=nil;
        nil.left=nil;
        nil.right=nil;
        nil.color=Color.BLACK;
    }


    private void simpleLeftRotation(NodeRB<T> node){
        NodeRB<T> key = node.right;
        node.right = key.left;
        if(key.left != nil){
            key.left.parent = node;
        }
        key.parent=node.parent;
        if(node.parent == nil){
            root = key;
        }
        else if(node == node.parent.left){
            node.parent.left = key;
        }
        else{
            node.parent.right = key;
        }
        key.left=node;
        node.parent=key;
    }

    private void simpleRightRotation(NodeRB<T> node){
        NodeRB<T> key = node.left;
        node.left = key.right;
        if(key.right != nil){
            key.right.parent = node;
        }
        key.parent=node.parent;
        if(node.parent == nil){
            root = key;
        }
        else if(node == node.parent.right){
            node.parent.right = key;
        }
        else{
            node.parent.left = key;
        }
        key.right=node;
        node.parent=key;
    }

    private void RBInsert(NodeRB<T> node){
        NodeRB<T> y = nil;
        NodeRB<T> x = root;
        while(x != nil){
            y = x;
            comparacoes++;
            if(node.element.compareTo(x.element)==0){
                //elemento ja existe, nao insere novamente
                return;
            }
            comparacoes++;
            if(node.element.compareTo(x.element)<0){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        //quando sair do while é pq chegou na folha
        node.parent = y;
        comparacoes++;
        if(y == nil){
            root = node;
        }
        //o problema estava aqui, ele tava comparando com x mas x é folha, tem que comparar com y que é pai de x;
        //tive que fazer isso para poder contabilizar as comparacoes de maneira correta, era apenas um else if
        else{ 
            comparacoes++;
            if(node.element.compareTo(y.element)<0){
                y.left = node;
            }
            else{
                y.right = node;
            }
        }
        
        node.left = nil;
        node.right = nil;
        node.color=Color.RED;
        RBInserFixUp(node);
    }

    private void RBInserFixUp(NodeRB<T> node){
        NodeRB<T> y =nil;
        while (node.parent.color == Color.RED){
            comparacoes++; 
            if (node.parent == node.parent.parent.left){
                y = node.parent.parent.right;
                comparacoes++;
                if(y.color == Color.RED){
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }
                else{
                    comparacoes++;
                    if(node == node.parent.right){
                        node = node.parent;
                        simpleLeftRotation(node);
                    }
                
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    simpleRightRotation(node.parent.parent);
                }
            }
            else{
                y = node.parent.parent.left;
                comparacoes++;
                if(y.color == Color.RED){
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }
                else {
                    comparacoes++;
                    if(node == node.parent.left){
                        node = node.parent;
                        simpleRightRotation(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    simpleLeftRotation(node.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private void RBTransplant(NodeRB<T> u, NodeRB<T> v){
        if (u.parent == nil){
            root = v;
        }
        else if(u == u.parent.left){
            u.parent.left = v;
        }
        else{
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private boolean RBRemove(NodeRB<T> node){
        NodeRB<T> x;
        NodeRB<T> y = node;
        Color y_original_color = y.color;
        if (node.left == nil){
             x = node.right;
             RBTransplant(node, node.right);
        }
        else if(node.right == nil){
            x=node.left;
            RBTransplant(node, node.left);
        }
        else{
            y = findMin(node.right);
            //to em duvida aqui, acho que vai dar erro na hora de recolorir. se der bug olhar aqui
            y_original_color = y.color;
            x = y.right;
            if(y.parent == node){
                x.parent = y;
            }
            else{
                RBTransplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            
            RBTransplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color; 
        }
        if(y_original_color == Color.BLACK){
            RBRemoveFixUp(x);
        }
        return true;
    }

    private void RBRemoveFixUp(NodeRB<T> x){
        NodeRB<T> w;
        while(x != root && x.color == Color.BLACK){
            if (x == x.parent.left){
                w = x.parent.right;
                if(w.color == Color.RED){
                    w.color=Color.BLACK;
                    x.parent.color = Color.RED;
                    simpleLeftRotation(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == Color.BLACK && w.right.color == Color.BLACK){
                    w.color = Color.RED;
                    x = x.parent;
                }
                else if(w.right.color == Color.BLACK){ 
                    w.left.color = Color.BLACK;
                    w.color = Color.RED;
                    simpleRightRotation(w);
                    w = x.parent.right;
                }
                if(w.right.color == Color.RED){
                    w.color = w.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color= Color.BLACK;
                    simpleLeftRotation(x.parent);
                    x = root;
                }
            }
            else{
                w = x.parent.left;
                if(w.color == Color.RED){
                    w.color=Color.BLACK;
                    x.parent.color = Color.RED;
                    simpleRightRotation(x.parent);
                    w = x.parent.left;
                }
                if(w.left.color == Color.BLACK && w.right.color == Color.BLACK){
                    w.color = Color.RED;
                    x = x.parent;
                }
                else if(w.left.color == Color.BLACK){ 
                    w.right.color = Color.BLACK;
                    w.color = Color.RED;
                    simpleLeftRotation(w);
                    w = x.parent.right;
                }
                if(w.left.color == Color.RED){
                    w.color = w.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color= Color.BLACK;
                    simpleRightRotation(x.parent);
                    x = root;
                }
            } 
        }
        x.color=Color.BLACK;
    }


    /**
     * Funcao que pega o menor elemento da subarvore direita
     * @param key
     * @return nodeMin
     */
    private NodeRB<T> findMin(NodeRB<T> node){
		while(node.left != nil) {
			node = node.left;
		}
		return node;
	}

    
    private NodeRB<T> findNode(T key){
        comparacoesFindRB=0;
		NodeRB<T> temp = root;
        while (temp!=nil){
            comparacoesFindRB++;
            if (key.compareTo(temp.element)<0) { 
                temp = temp.left;
            }else if (key.compareTo(temp.element)==0) { 
                comparacoesFindRB++;
                return temp; 
            } else {
                comparacoesFindRB++;
                temp = temp.right;
            }
        }
        return null;
	}
    

    /**
     * Funcao que recebe um no e imprime em ordem simetrica
     * @param node
     */
    private void printInOrder(NodeRB<T> node){
        if(node == nil) {
            System.out.println("\nNo nodes in the tree\n");
            return;
        }
        if(node.left != nil) {
            printInOrder(node.left);
        }
        System.out.println(node.element + " ");
        if(node.right != nil) {
            printInOrder(node.right);
        }
    }


    /**
     * Funcao que imprime os elementos em posOrdem, criei para testes
     * @param node
     */
    private void printPosOrder(NodeRB<T> node){
        if(node == nil){
            System.out.println("\n No nodes in the tree\n");
            return;
        }
        if(node.left!=nil){
            printPosOrder(node.left);
        }
        if(node.right!=nil){
            printPosOrder(node.right);
        }
        System.out.println(node.element + "");
    }

    /**
     * Funcao que percorre a arvore para retornar a altura máxima da arvore
     * @param root
     * @return HeightMax
     */
    private int getHeight(NodeRB<T> root){
        NodeRB<T> node = root;
        if(node == nil){
            return 0;
        }
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        
        return Math.max(l, r)+1;
    }


    @Override
    public void insert(T element){
        NodeRB<T> newNode = new NodeRB<>(element);
        RBInsert(newNode);
    }

    @Override
    public boolean remove(T element){
        NodeRB<T> nodeBackup = new NodeRB<>(element);
        nodeBackup = findNode(element);
        if(nodeBackup == nil){
            System.out.println("\n*Elemento não enconrado*\n");
            return false;
        }
        if(RBRemove(nodeBackup)){
            return true;
        }
        else{
            System.out.println("\n*Falha na remocao*\n");
            return false;
        }
    }
    
    @Override
    public boolean find(T node){
        if(findNode(node) != null){
            return true;
        }
        return false;
    }

    @Override
    public int getHeight(){
        return getHeight(root);
    }

    
    @Override
    public void printInOrder(){
        printInOrder(root);
    }

    /**
	 * para comparacoes criei essas funcoes aqui
	 */

    public int getComparacoesFindRB(){
        return comparacoesFindRB;
    }
    
	public int getComparacoes(){
		return comparacoes;
	}

	public void resetComparacoes(){
		comparacoes=0;
	}
}
