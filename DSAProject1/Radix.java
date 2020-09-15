import java.io.*;
import java.util.*;
//fix, every time something moves, its a movement. assignment is not a movement



class Radix {
	static int comparisons = 0;
	static int movements = 0;
	 static int getMax(int arr[], int n){
		 int mx = arr[0];
		 for (int i = 1; i < n; i++,comparisons++) {
			 if (arr[i] > mx) {
				 mx = arr[i];
				 movements++;
			 }
			 comparisons++;
		 }
		 return mx;
 }
 static void countSort(int arr[], int n, int exp) {
	 int output[] = new int[n];
	 int i;
	 int count[] = new int[10];//add comparisons to each for loop because they are comparing every time
	 Arrays.fill(count,0);
	 for (i = 0; i < n; i++,comparisons++) {
		 count[ (arr[i]/exp)%10 ]++;
		 movements++;
		 
	 }
	 // Change count[i] so that count[i] now contains
	 // actual position of this digit in output[]
	 for (i = 1; i < 10; i++,comparisons++) {
		 count[i] += count[i - 1];
		 movements++;
	 }
	 // Build the output array
	 for (i = n - 1; i >= 0; i--,comparisons++){
		 output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
		 count[ (arr[i]/exp)%10 ]--;
		 movements+=2;//there are two movements, so i add 2
	 }
	 for (i = 0; i < n; i++,comparisons++) {
		 	arr[i] = output[i];
		 	movements++;
	 }
 }
 static void radixsort(int arr[], int n)
 { // Find the maximum number to know number of digits
	 int m = getMax(arr, n);
	 for (int exp = 1; m/exp > 0; exp *= 10,comparisons++)
		 countSort(arr, n, exp);
 }
 static void print(int arr[], int n) {
	 for (int i=0; i<n; i++)
	 System.out.print(arr[i]+" ");
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