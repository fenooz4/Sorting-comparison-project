//done, not tested
public class InsertionSort {
	static long comparisons = 0;
	static int movements = 0;
//the method for sorting numbers
	public static void insertionSort(int[] list) {
		for(int i = 1;i<list.length;i++,comparisons++) {
			int currentElement = list[i];
			int k;
			for(k=i-1; k>=0 && list[k] > currentElement; k--,comparisons+=2) {
				list[k+1] = list[k];
				
				
			}
			
			//insert the current element into list[k+1]
			list[k+1] = currentElement;
			movements++;
		}
	}
	public static long getComparisons() {
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
