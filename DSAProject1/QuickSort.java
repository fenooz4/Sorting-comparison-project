//fix, every swap is 1 movement, not 3





public class QuickSort {
	static int comparisons = 0;
	static int movements = 0;
	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
 static int partition(int arr[], int low, int high) 
 { 
     int pivot = arr[high];  movements++;//because accessing the array takes time
     int i = (low-1); // index of smaller element 
     for (int j=low; j<high; j++,comparisons++) 
     { 
         // If current element is smaller than the pivot 
         if (arr[j] < pivot) //comparison
         { 
             i++; 
             comparisons++;
             // swap arr[i] and arr[j] 
             int temp = arr[i]; //1
             arr[i] = arr[j]; //2
             arr[j] = temp; //3
             movements+=3;
         } 
         comparisons++;//the if is still a comparison if it doesn't end up true
     } 

     // swap arr[i+1] and arr[high] (or pivot) 
     int temp = arr[i+1]; 
     arr[i+1] = arr[high]; 
     arr[high] = temp; 
     movements+=3;
     return i+1; 
 } 


 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
 static void sort(int arr[], int low, int high) 
 { 
     if (low < high) 
     { 
         /* pi is partitioning index, arr[pi] is  
           now at right place */
         int pi = partition(arr, low, high); 
         comparisons++;
         // Recursively sort elements before 
         // partition and after partition 
         sort(arr, low, pi-1); 
         sort(arr, pi+1, high); 
     } 
     comparisons++;
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
