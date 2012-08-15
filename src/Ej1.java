import java.util.Arrays;
import java.util.Random;

public class Ej1 {

	public static void run() {
		int[] array = createRandomArray(1000);
		long start;
		long end;
		
		System.out.println(Arrays.toString(array));
		
		System.out.println("has duplicates: " + hasDuplicates(array));
	
		start = System.currentTimeMillis();
		bubbleSort(array);
		
		end = System.currentTimeMillis();
		
		System.out.println(Arrays.toString(array));
		System.out.println("is sorted: " + isSorted(array));
		
		System.out.println(end - start);
	}

	
	public static int[] createRandomArray(int n){
		int[] array = new int[n];
		
		Random random = new Random();	
		for (int i = 0; i < n; i++){
			array[i] = random.nextInt(n);
		}
		return array;
	}
	
	public static void swap(int[] array, int i, int j){
		int aux;
		aux = array[i];
		array[i] = array[i+1];
		array[i+1] = aux;
	}
	
	public static void bubbleSort(int[] array){
		boolean swapped;
		
		do{
			swapped = false;
			
			for(int i = 0; i < array.length - 1; i++){
				if (array[i] > array[i+1]){
					swapped = true;
					swap(array, i, i+1);
				}
			}
		} while (swapped);

	}
	
	public static boolean isSorted(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			if (array[i] > array[i+1]){
				return false;
			}
		}
		return true;
	}
	
	private static boolean isDuplicated(int[] array, int position){
		for(int i = 0; i < array.length; i++){
			if (i != position && array[i] == array[position]){
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasDuplicates(int[] array){
		for(int i = 0; i < array.length; i++){
			if (isDuplicated(array, i)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean ej4(int[] array){
		/*Escribir un algoritmo eficiente para determinar si existe un entero i tal que Ai = i en un vector de
			enteros A1 < A2 < A3 < ... < An. ¿Cuál es la complejidad del algoritmo?
		 */
		
		// con solo positivos basta ver si empieza en cero o en uno, y ya sabes O(1)
		
		for(int i = 0; i < array.length; i++){
			if (array[i] == i){
				return true;
			}
			if(array[i] > i){
				return false;
			}
		}
		return false;
	}
}

