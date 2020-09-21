public class QuickSort{

	static long comparisons = 0;
	static int  movements = 0;
	
	
	public static void quickSort(int[] list){
		quickSort(list,0,list.length-1);
		}
	
	
	private static void quickSort(int[] list, int first, int last){
		comparisons++;
		if(last > first){
			comparisons+=2;
			int pivotIndex = partition(list,first,last);
			if(first<pivotIndex-1)
				quickSort(list,first,pivotIndex-1);
			if(pivotIndex<last)
				quickSort(list,pivotIndex,last);
		}
	}
	//partition the Array list [first..last]
	private static int partition(int[] list,int first, int last){
		int pivot = list[(last+first)/2];//choose the element in the middle as the pivot
		int low = first;
		int high = last;
		
		while(high>=low){
			//search forward from left
			while(low <= high && list[low] < pivot) {
				low++;
				comparisons++;
			}
			//search backwards from right
			while(low <= high && list[high] > pivot) {
				high--;
				comparisons++;
			}
				
			comparisons++;
			//swap 2 elements in the list
			if(high >= low){
				
				int temp = list[high];
				list[high]=list[low];
				list[low] = temp;
				low++;
				high--;
				movements++;
				
			}
			comparisons++;
		}
		
		return low;
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


