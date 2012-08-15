import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class SetList<E> implements Set<E> {
	private Node<E> first;
	private Node<E> last;
	public SetList(){
		
	}
	
	public static void run(){
		SetList<String> set = new SetList<String>();
		
		System.out.println("esta A?");
		System.out.println(set.contains("A"));
		
		System.out.println("Ingreso A");
		System.out.println(set.add("A"));
		
		System.out.println("Ingreso A");
		System.out.println(set.add("A"));
		
		System.out.println("Ingreso B");
		System.out.println(set.add("B"));
		
		System.out.println("esta A?");
		System.out.println(set.contains("A"));
		
		System.out.println("esta B?");
		System.out.println(set.contains("B"));	
		
		System.out.println("esta C?");
		System.out.println(set.contains("C"));	
	}
	
	public int size(){
		throw new UnsupportedOperationException();
	}
	
	public boolean isEmpty(){
		throw new UnsupportedOperationException();

	}
	


   public Iterator<E> iterator(){
	   throw new UnsupportedOperationException();

   }
   
   public Object[] toArray(){
	   throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection <?> c){
	   throw new UnsupportedOperationException();
   }
	
   private static class Node<E>{
		E head;
		Node<E> tail;
		Node(E e){
			head = e;
		}
	}
	
   public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
	
   public boolean contains(Object e){
	   return recursiveContains(e, first);
   }
   
   private boolean recursiveContains(Object e, Node<E> current){
	   if (current == null){
		   return false;
	   }
	   
	   if (current.head.equals(e)){
		  return true;
	   }
	   return recursiveContains(e, current.tail);
   }

	public boolean add(E e) {
		if (contains(e)){
			return false;
		} else {
			addLast(e);
			return true;
		}
	}
	private void addLast(E e){
		if (first == null){
			last = new Node<E>(e);
			first = last;
		} else {
			last.tail = new Node<E>(e);
			last = last.tail;
		}
	}
	

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();

	}

	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();

	}

	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();

	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();

	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

}
