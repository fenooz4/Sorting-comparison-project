//done not tested
public class MergeSort {
	static int comparisons =0;
	static int movements = 0;
	//the method for sorting the numbers
	public static void mergeSort(int[] list) {
		if(list.length>1) {
			//merge sort the first half
			int[] firstHalf = new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			mergeSort(firstHalf);
			
			//merge sort second half
			int secondHalfLength = list.length-list.length/2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//merge firsthalf with secondhalf into the list
			merge(firstHalf, secondHalf, list);
		}
	}
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;//Current Index in list1
		int current2 = 0;//Current Index in list2
		int current3 = 0;//Current Index in temp
		
		while(current1<list1.length && current2<list2.length) {
			if(list1[current1]<list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
			comparisons+=3;//while has 2 comparisons, then an if
		}
		while(current1<list1.length) {
			temp[current3++] = list1[current1++];
			comparisons++;//while condition
			movements++;//swap
		}
		while(current2<list2.length) {
			temp[current3++] = list2[current2++];
			comparisons++;//while condition
			movements++;//swap
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
