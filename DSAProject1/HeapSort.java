
public class HeapSort {
	//heap sort method
	public static<E extends Comparable<E>> void heapSort(E[] list) {
		//create a heap of integers
		Heap<E> heap = new Heap<>();
		
		//add elements to the heap
		for(int i = 0;i<list.length;i++) 
			heap.add(list[i]);
		
		//remove elements from the heap
		for(int i = list.length -1;i >=0;i--)
			list[i] = heap.remove();
		
	}
	
	
}
