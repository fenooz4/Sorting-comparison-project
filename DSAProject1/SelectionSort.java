//not done
public class SelectionSort {
	static int comparisons = 0;
	static int movements = 0;
	//the method for sorting the numbers
	public static void selectionSort(int[] list) {
		for(int i = 0;i<list.length -1;i++) {
			//find the minimum of the list
			int currentMin = list[i];
			int currentMinIndex = i;
			for(int j = i+1;j<list.length;j++) {
				if(currentMin>list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			//Swap list[i] with List[currentMinIndex] if necessary
			if(currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
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
