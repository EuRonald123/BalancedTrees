package TreeRB;
//import Interface.BalancedTree;

public class RBtree<T extends Comparable<T>>{

    private final NodeRB<T> nil = new NodeRB<>(null);

    private NodeRB<T> root;
    
    public RBtree(){
        this.root = nil;
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


}
