//done not tested
public class HeapSort {
	static int comparisons =0;
	static int movements = 0;
	//heap sort method
	public static<E extends Comparable<E>> void heapSort(E[] list) {
		//create a heap of integers
		Heap<E> heap = new Heap<>();
		
		//add elements to the heap
		for(int i = 0;i<list.length;i++,comparisons++) 
			heap.add(list[i]);
		
		//remove elements from the heap
		for(int i = list.length -1;i >=0;i--,comparisons++)
			list[i] = heap.remove();
		
	}
	public static int getComparisons() {
		return comparisons;
	}
	public static int getMovements() {
		return movements;
	}
	public static void resetMovements() {
		movements = 0;
	}
	public static void resetComparisons() {
		movements = 0;
	}
	
}
