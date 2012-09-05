
public class EdaListPriorityQueue<E> implements EdaPriorityQueue<E>{
	private Node<E> first;
	
	private static class Node<E> {
		E elem;		
		Node<E> tail;
		int priority;
		
		public int getPriority(){
			return priority;
		}
		
		Node(E elem, int priority){
			this.elem = elem;
			this.priority = priority;
		}
	}
	
	@Override
	public void enqueue(E elem, int priority) {
		first = recursiveEnqueue(new Node<E>(elem, priority), first);
	}
	
	private Node<E> recursiveEnqueue(Node<E> toEnqueue, Node<E> node){
		if(node == null){
			return toEnqueue;
		}else if(toEnqueue.getPriority() < node.getPriority()){
			toEnqueue.tail = node;
			return toEnqueue;
		}
		node.tail = recursiveEnqueue(toEnqueue, node.tail);
		return node;
	}
	

	@Override
	public E dequeue() {
		E aux = first.elem;
		first = first.tail;
		return aux;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}

