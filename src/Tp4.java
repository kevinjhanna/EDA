import java.util.Arrays;


public class Tp4 {
	public static void run() {
//		int[] array = Ej1.createRandomArray(5);
//		long start;
//		long end;
//		
//		System.out.println(Arrays.toString(array));
//	
//		start = System.currentTimeMillis();
//		array = sortInRange(array);
//		end = System.currentTimeMillis();
//		
//		System.out.println(end - start);
//		System.out.println(Arrays.toString(array));		
		
		ej2();

	}

	public static int[] sortInRange(int[] values){
		/*Se tiene un arreglo desordenado de enteros en 
		* donde se sabe que los valores almacenados pertenecen
 		* al intervalo [0, 9999]. 
 		* Implementar un algoritmo que lo ordene con complejidad
		* temporal O(N).
 		* ¿Qué ocurre con la eficiencia de este algoritmo para arreglos de pocos elementos?
		 */
		int[] counts = new int[10000];
		int k = 0;
		int[] aux = new int[values.length];
		
		for(int i = 0; i < values.length; i++){
			counts[values[i]] += 1;
		}
		
		for(int i= 0; i < counts.length; i++){
			for(int j = 0; j < counts[i]; j++){
				aux[k++] = i;
			}
		}
		return aux;
		
	}
	
	public static void ej2(){
			int[] sizes = new int[] {5000, 10000, 20000, 40000, 80000};
			long start, time;
		for (int size : sizes) {
			int[] array = Ej1.createRandomArray(size); 
			System.out.println(Arrays.toString(array));

			start = System.currentTimeMillis();
			quicksort(array);
			time = System.currentTimeMillis() - start;
			
			System.out.println(Arrays.toString(array));
			System.out.println("Size: " + size + " Time: " + time + " ms");
		}
	}
	public static void quicksort(int[]values){
		sort(values, 0, values.length);
	}

	private static void sort(int[] values, int from, int to){
		int n = to - from + 1;
		if (n < 2){ return; }
		Ej1.swap(values, from, (int)(Math.random() * n) + from);
		int k = from;
		for (int i = from + 1; i <= to; i++){
			if (values[i] < values[from]){
				Ej1.swap(values, ++k, i);
			}
		}
		Ej1.swap(values, k, from);
		sort(values, from, k-1);
		sort(values, k+1, to);
	}
}
