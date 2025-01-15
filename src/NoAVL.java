public class NoAVL<T> {
    T element;
	NoAVL<T> left;
	NoAVL<T> right;
	int height;
	
	NoAVL(T element){
		this(element, null, null);
	}
	
	NoAVL(T element, NoAVL<T> left, NoAVL<T> right){
		this.element = element;
		this.left = left;
		this.right = right;
		this.height = 1;
	}
}