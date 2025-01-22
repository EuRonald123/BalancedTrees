package TreeRB;


public class NodeRB<T> {
    T element;
    NodeRB<T> parent;
    NodeRB<T> left;
    NodeRB<T> right;
    Color color;
    int n;

    enum Color{
        RED,BLACK
    }
    
    public NodeRB(T e){
        this(e,null,null,null,false);
    }

    public NodeRB(T e,NodeRB<T> parent,NodeRB<T> left,NodeRB<T> right,boolean c){
        this.element = e;
        this.parent=parent;
        this.left=left;
        this.right=right;
        this.color=Color.RED;
        //this.n;
    }
}
