
public class InsertionSort {
//the method for sorting numbers
	public static void insertionSort(int[] list) {
		for(int i = 1;i<list.length;i++) {
			int currentElement = list[i];
			int k;
			for(k=i-1; k>=0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
			}
			
			//insert the current element into list[k+1]
			list[k+1] = currentElement;
		}
	}
}
