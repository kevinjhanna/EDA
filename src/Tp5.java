
public class Tp5 {
	public static void run(){
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.root = new BinaryTree.Node<String>("Hola");
		tree.root.left = new BinaryTree.Node<String>("izq");
		tree.root.right = new BinaryTree.Node<String>("der");
		tree.root.right.right = new BinaryTree.Node<String>("mas a la der");
		
		System.out.println(tree.root.getValue());
		System.out.println(tree.root.left.getValue());
		System.out.println(tree.root.right.getValue());
		System.out.println(tree.root.right.right.getValue());
		
		BinaryTree<Integer> integerTree = tree.map(new Function<String, Integer>(){ 
			public  Integer apply(String str){
			 return str.length();
		}
		});
		
		System.out.println(integerTree.root.getValue());

		System.out.println(integerTree.root.left.getValue());
		System.out.println(integerTree.root.right.getValue());
		System.out.println(integerTree.root.right.right.getValue());
		
		System.out.println(integerTree.isMirrowStructure(tree));
	}
	
}
