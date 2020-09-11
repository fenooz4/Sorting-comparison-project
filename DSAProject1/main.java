import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class main {
	static Random rand = new Random();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
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
		printArray(list);
	}
	
	
	
	
	 static void printArray(int arr[]) 
	 { 
	     int n = arr.length; 
	     for (int i=0; i<n; i++) 
	         System.out.print(arr[i]+" "); 
	     System.out.println(); 
	 } 
	 
	 public static void test() {
		 //test each sort and make sure they work
		 int [] list = generateRandomList(16);
		 System.out.println("Original");
		 printArray(list);
		
		 Integer[] list2 = toInteger(list);
		 HeapSort.heapSort(list2);
		 System.out.println("HeapSort");
		 list = toInt(list2);
		 printArray(list);
	 }
	 
	 
	 
	 public static Integer[] toInteger(int[] list)
	 {
		 Integer[] list2 = new Integer[list.length];
			for(int i = 0;i<list.length;i++)
			{
				list2[i]=list[i];
			}
			return list2;
	 }
	 public static int[] toInt(Integer[] list)
	 {
		 int[] list2 = new int[list.length];
			for(int i = 0;i<list.length;i++)
			{
				list2[i]=list[i];
			}
			return list2;
	 }
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
