//done




public class Heap<E extends Comparable<E>> {
	static int comparisons =0;
	static int movements = 0;
	
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	
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
	//create default heap
	public Heap() {
	}
	
	//create heap from an array of objects
	public Heap(E[] objects) {
		for(int i = 0;i< objects.length;i++,comparisons++) {
			add(objects[i]);
		}
	}
	
	//add a new object into the heap
	public void add(E newObject) {
		list.add(newObject);//Append to Heap
		movements++;
		int currentIndex = list.size()-1;//the index of the last node
		
		while(currentIndex >0) {
			comparisons++;
			int parentIndex = (currentIndex-1)/2;
			//swap if the current object is greater than its parent
			if(list.get(currentIndex).compareTo(list.get(parentIndex))>0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
				movements++;
				comparisons++;
			}
			else {
				comparisons+=2;
				break;//the tree is a heap now
			}
				
			
			currentIndex = parentIndex;
			
		}
	}
	
	//remove the root from the heap
	public E remove() {
		if(list.size()==0) return null;
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		movements++;
		int currentIndex = 0;
		while(currentIndex < list.size()) {
			int leftChildIndex = 2*currentIndex+1;
			int rightChildIndex = 2*currentIndex+2;
			comparisons++;
			//find the maximum between the two children
			if(leftChildIndex>=list.size()) {comparisons++;break;}//the tree is a heap
			int maxIndex = leftChildIndex;
			if(rightChildIndex < list.size()) {
				if(list.get(maxIndex).compareTo(list.get(rightChildIndex))<0) {
					comparisons+=2;
					maxIndex = rightChildIndex;
				}
				comparisons++;
			}
			
			//swap if the current node is less than the maximum
			if(list.get(currentIndex).compareTo(list.get(maxIndex))<0) {
				comparisons++;
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				movements++;
				currentIndex = maxIndex;
			}
			else
				break;//the tree is a heap
			
		}
		return removedObject;
	}
	
	
	public int getSize() {
		return list.size();
	}
	
}
	
