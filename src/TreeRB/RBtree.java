package TreeRB;
//import Interface.BalancedTree;

import TreeRB.NodeRB.Color;

public class RBtree<T extends Comparable<T>>{

    public final NodeRB<T> nil = new NodeRB<>(null);

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
    
    public void insert(T element){
        NodeRB<T> newNode = new NodeRB<>(element);
        RBInsert(newNode);
    }

    private void RBInsert(NodeRB<T> node){
        NodeRB<T> y = nil;
        NodeRB<T> x = root;
        while(x != nil){
            y = x;
            if(node.element.compareTo(x.element)<0){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        //quando sair do while é pq chegou na folha
        node.parent = y;
        if(y == nil){
            root = node;
        }
        else if(node.element.compareTo(x.element)<0){
            y.left = node;
        }
        else{
            y.right = node;
        }
        node.left = nil;
        node.right = nil;
        node.color=Color.RED;
        RBInserFixUp(node);
    }

    private void RBInserFixUp(NodeRB<T> node){
        NodeRB<T> y = nil;
        while (node.parent.color == Color.RED){
            if (node.parent == node.parent.parent.left){
                y = node.parent.parent.right;
                if(y.color == Color.RED){
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }
                else if(node == node.parent.right){
                    node = node.parent;
                    simpleLeftRotation(node);
                }
                node.parent.color = Color.BLACK;
                node.parent.parent.color = Color.RED;
                simpleRightRotation(node.parent.parent);
            }
            else{
                y = node.parent.parent.left;
                if(y.color == Color.RED){
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }
                else if(node == node.parent.left){
                    node = node.parent;
                    simpleRightRotation(node);
                }
                node.parent.color = Color.BLACK;
                node.parent.parent.color = Color.RED;
                simpleLeftRotation(node.parent.parent);
            }
        }
        root.color = Color.BLACK;
    }


}
