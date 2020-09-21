
public class Trial {
	public int getAlg() {
		return alg;
	}
	public void setAlg(int alg) {
		this.alg = alg;
	}
	public int getMovements() {
		return movements;
	}
	public void setMovements(int movements) {
		this.movements = movements;
	}
	public long getComparisons() {
		return comparisons;
	}
	public void setComparisons(long comparisons) {
		this.comparisons = comparisons;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getPeakMemory() {
		return peakMemory;
	}
	public void setPeakMemory(int peakMemory) {
		this.peakMemory = peakMemory;
	}
	int trial;
	public int getTrial() {
		return trial;
	}
	public void setTrial(int trial) {
		this.trial = trial;
	}
	int alg;
	int movements;
	long comparisons;
	int listSize;
	int peakMemory;
	long time;
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Trial() {
		alg = 0;
		movements = 0;
		comparisons = 0;
		listSize = 0;
		peakMemory = 0;
	}
	
	public String toString()
	{
		String str = "Trial: "+trial+"\n"
				+ "List Size: "+listSize+"\n"
				+ "Movements: "+movements+"\n"
				+ "Comparisons: "+comparisons+"\n"
				+ "Total Time: "+time+" Nanoseconds";
		
		
		
		return str;
	}
}
