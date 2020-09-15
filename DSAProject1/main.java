import java.util.Arrays;

import java.util.Scanner;
import java.util.Random;
public class main {
	static Random rand = new Random();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		
		
		
		Scanner input = new Scanner(System.in);
		long startTime = 0;
		long endTime =0;
		int comparisons = 0;
		int movements = 0;
		Integer[] list2;
		int alg = 0;
		long totalTime = 0;
		
		
		
		System.out.print("Enter an integer between 1000 and 50000: ");
		int listSize = input.nextInt();
		while (listSize<1000||listSize>50000) {
			if(listSize<1000||listSize>50000) {
				System.out.println("The number must be between 1000 and 50000, please re-enter a valid number");
				listSize = input.nextInt();
			}
		}
		int[] list = new int[listSize];
		
		
		
		
		System.out.println("Enter an integer 1-4 corresponding to the list type you want. Your options are: \n"
				+ "1. Ordered List\n"
				+ "2. Reverse Order List\n"
				+ "3. Almost Ordered List\n"
				+ "4. Random Order List");
		int listType = input.nextInt();
		if(listType <1 || listType>4)
			System.out.println("Invalid number");
		else if(listType==1)
			list = generateOrderedList(listSize);
		else if(listType==2)
			list = generateReverseOrderedList(listSize);
		else if(listType==3)
			list = generateAlmostOrderedList(listSize);
		else
			list = generateRandomList(listSize);
		System.out.println("List generated");
		
		
		
		
		while(alg <1 || alg>6) {
			System.out.println("Enter an integer 1-6 corresponding to the sort algorithm you want. Your options are: \n"
					+ "1. Insertion Sort\n"
					+ "2. Selection Sort\n"
					+ "3. Quick Sort\n"
					+ "4. Heap Sort\n"
					+ "5. Merge Sort\n"
					+ "6. Radix Sort");
			alg = input.nextInt();
			if(alg <1 || alg>6)
				System.out.println("Invalid number");
			else if(alg==1) {
				startTime = System.nanoTime();
				InsertionSort.insertionSort(list);
				endTime = System.nanoTime();
				comparisons = InsertionSort.getComparisons();
				movements = InsertionSort.getMovements();
				totalTime = endTime-startTime;
				InsertionSort.resetMovements();
				InsertionSort.resetComparisons();
			}
				
			else if(alg==2) {
				startTime = System.nanoTime();
				SelectionSort.selectionSort(list);
				endTime = System.nanoTime();
				comparisons = SelectionSort.getComparisons();
				movements = SelectionSort.getMovements();
				totalTime = endTime-startTime;
				SelectionSort.resetMovements();
				SelectionSort.resetComparisons();
			}
				//quick sort chosen
			else if(alg==3) {
				startTime = System.nanoTime();
				QuickSort.sort(list, 0, list.length-1);
				endTime = System.nanoTime();
				comparisons = QuickSort.getComparisons();
				movements = QuickSort.getMovements();
				totalTime = endTime-startTime;
				QuickSort.resetMovements();
				QuickSort.resetComparisons();
			}
				//heap sort chosen
			else if(alg == 4)
			{
				list2 = toInteger(list);
				
				startTime = System.nanoTime();
				HeapSort.heapSort(list2);
				endTime = System.nanoTime();
				comparisons = HeapSort.getComparisons()+Heap.getComparisons();
				movements = HeapSort.getMovements()+Heap.getMovements();
				totalTime = endTime-startTime;
				list = toInt(list2);
				HeapSort.resetMovements();
				HeapSort.resetComparisons();
				Heap.resetComparisons();
				Heap.resetMovements();
			}
				//merge sort chosen
			else if(alg == 5) {
				startTime = System.nanoTime();
				MergeSort.mergeSort(list);
				endTime = System.nanoTime();
				comparisons = MergeSort.getComparisons();
				movements = MergeSort.getMovements();
				totalTime = endTime-startTime;
				MergeSort.resetMovements();
				MergeSort.resetComparisons();
			}
				//radix sort chosen
			else {
				startTime= System.nanoTime();
				Radix.radixsort(list, list.length);
				endTime = System.nanoTime();
				comparisons = Radix.getComparisons();
				movements = Radix.getMovements();
				totalTime = endTime-startTime;
				Radix.resetMovements();
				Radix.resetComparisons();
			}
			System.out.println("Movements: "+movements+"\n"
				+ "Comparisons: "+comparisons+"\n"
				+ "Total Time: "+totalTime+" Nanoseconds");
		}
		
		
		
		//reset the numbers and do this as many times as as necessary determine winner
		
		
	}
	
	
	
	//regular array printing, element by element
	 static void printArray(int arr[]) 
	 { 
	     int n = arr.length; 
	     for (int i=0; i<n; i++) {
	    	 System.out.print(arr[i]+" "); 
	    	 System.out.println();
	     }
	    	 
	      
	 } 	 
	 //this method is made to convert an int[] list to an Integer[] list to make it compatible with Heap Sort, which only takes Objects
	 public static Integer[] toInteger(int[] list)
	 {
		 Integer[] list2 = new Integer[list.length];
			for(int i = 0;i<list.length;i++)
			{
				list2[i]=list[i];
			}
			return list2;
	 }
	 //reverts the Integer[] List to a int[] list so it has better harmony with the rest of the code, only used for Heapsort
	 public static int[] toInt(Integer[] list)
	 {
		 int[] list2 = new int[list.length];
			for(int i = 0;i<list.length;i++)
			{
				list2[i]=list[i];
			}
			return list2;
	 }
	 //the index is the value, therefore in order
	 public static int[] generateOrderedList(int size) {
		 System.out.println("Generating Ordered List...");
		 int[] list =  new int[size];
		 int counter = 0;
		 while(counter<size)
		 {
			 list[counter]=counter;
			 counter++;
		 }
		 return list;
	 }
	 
	 
	 
	 
	 //it counts from size to 1 in order to generate reverse elements for the array
	 public static int[] generateReverseOrderedList(int size) {
		 System.out.println("Generating Reverse List...");
		 int[] list =  new int[size];
		 int counter = 0;
		 while(counter<size)
		 {
			 list[counter]=size-counter;
			 counter++;
		 }
		 return list;
	 }
	 
	 
	 
	 
	 
	 public static int[] generateAlmostOrderedList(int size) {
		 System.out.println("Generating Almost Ordered List...");
		 int[] list =  new int[size];
		 double x = .2;
		 int factor = (int) (size* x);
		 int counter = 0;
		 while(counter<size-factor)
		 {
			
			 list[counter]=counter*2;
			 counter++;
		 }
		 while(counter<size)
		 {
			 list[counter] = rand.nextInt((size-factor)*2);
			 if(list[counter]%2==0)
				 list[counter]+=1;
			 counter++;
		 }
		 return list;
	 }
	 
	 
	 
	 
	 public static int[] generateRandomList(int size) {
		 System.out.println("Generating Random List...");
		 int[] list =  new int[size];
		 double x = .8;
		 int factor = (int) (size* x);
		 int counter = 0;
		 while(counter<size-factor)
		 {
			
			 list[counter]=counter*2;
			 counter++;
		 }
		 while(counter<size)
		 {
			 list[counter] = rand.nextInt((size-factor)*2);
			 if(list[counter]%2==0)
				 list[counter]+=1;
			 counter++;
		 }
		 return list;
	 }
}

		




//todo find a way to call getComparisons and getMovements from classes while getting the actual movements and classes
//find a way to track movements and comparisons
//make GUI









