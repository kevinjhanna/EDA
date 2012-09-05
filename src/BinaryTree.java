import java.util.Comparator;


public class BinaryTree<T>{
	public Node<T> root;
	Comparator<? super T> cmp;
	
	BinaryTree(Comparator <? super T> cmp){
		this.cmp = cmp;
	}
	BinaryTree(){
	}
	
	public static class Node<T>{
		T value;
		Node<T> left;
		Node<T> right;
		
		Node(T value){
			this.value = value;
		}
		
		T getValue(){
			return value;
		}
	}

//	public void add(T value){
//		root = add(root, value);
//	}
	
//	private Node<T> add(Node<T> tree, T value){
//		
//		if (tree == null){
//			return new Node<T>(value);
//		}
//		
//		int c = cmp.compare(tree.getValue(), value);
//		
//		if (c > 0){
//			tree.left = add(tree.left, value);
//		} else if(c < 0) {
//			tree.right = add(tree.right, value);
//		}
//		return tree;
//	}
	
	public <S> BinaryTree<S>  map(Function<T, S> f){
		BinaryTree<S> newTree = new BinaryTree<S>();
		newTree.root = recursiveMap(this.root, f);
		return newTree;
	}
	
	private <S> Node<S> recursiveMap(Node<T> oldTree, Function<T, S> f){
		if (oldTree == null){
			return null;
		}
		
		Node<S> newTree = new Node<S>(f.apply(oldTree.getValue()));
		
		newTree.left = recursiveMap(oldTree.left, f);
		newTree.right = recursiveMap(oldTree.right, f);
		newTree.value = f.apply(oldTree.getValue());
		return newTree;
		
	}
	
	
	public <S> Boolean isMirrowStructure(BinaryTree<S> tree){
		//	Implementar un método que determine si dos árboles binarios son espejados sólo en cuanto a su
		//	  estructura.
		
		return recursiveMirror(this.root, tree.root);
	}
	
	private <S> Boolean recursiveMirror(Node<T> treeOne, Node<S> treeTwo){
		if (treeOne == null && treeTwo != null){
			return false;
		}
		
		if (treeOne != null && treeTwo == null){
			return false;
		}
		if (treeTwo == null && treeOne == null){
			return true;
		}else if (recursiveMirror(treeOne.left, treeTwo.right) && recursiveMirror(treeOne.right, treeTwo.left)){
			return true;
		} else {
			return false;
		}
	}
}