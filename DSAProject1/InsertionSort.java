//not done
public class InsertionSort {
	static int comparisons = 0;
	static int movements = 0;
//the method for sorting numbers
	public static void insertionSort(int[] list) {
		for(int i = 1;i<list.length;i++) {
			int currentElement = list[i];
			int k;
			for(k=i-1; k>=0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				comparisons+=2;
				movements+=1;
			}
			
			//insert the current element into list[k+1]
			list[k+1] = currentElement;
			movements+=1;
		}
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
//done not tested