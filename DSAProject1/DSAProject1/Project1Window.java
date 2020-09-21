import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Project1Window extends JFrame {

	static Random rand = new Random();
	//the following are to make sure every algorithim has been used and every list type
	int a1 = 0;
	int a2 = 0;
	int a3 =0;
	int a4=0;
	int a5=0;
	int a6=0;
	
	int l1=0;
	int l2=0;
	int l3=0;
	int l4=0;
	
	static int listSize;
	static int listType;
	static int alg;
	static long startTime = 0;
	static long endTime =0;
	static long totalTime = 0;
	static long comparisons = 0;
	static int movements = 0;
	static Integer[] list2;
	static Trial[] history = new Trial[24];
	static int iteration = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project1Window frame = new Project1Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		startTime = 0;
		endTime =0;
		comparisons = 0;
		movements = 0;
		alg = 1;
		totalTime = 0;
		listType = 0;
		listSize = 1000;
		
	}

	/**
	 * Create the frame.
	 */
	public Project1Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAlg = new JLabel("Sorting Algorithims");
		lblAlg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		
		JButton btnSelection = new JButton("Selection");
		JButton btnInsertion = new JButton("Insertion");
		JButton btnQuick = new JButton("Quick");
		JButton btnMerge = new JButton("Merge");
		JButton btnHeap = new JButton("Heap");
		JButton btnRadix = new JButton("Radix");

		JLabel lblWinner = new JLabel("Winning Algorithm");
		JLabel lblWinningAlgorithimDisplay = new JLabel("");
		
		JSeparator separator_1 = new JSeparator();
		
		JComboBox cbListType = new JComboBox();
		cbListType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				listType = cbListType.getSelectedIndex();
				if(cbListType.getSelectedIndex()==0)
					l1 =1;
				else if(cbListType.getSelectedIndex()==1)
					l2=1;
				else if (cbListType.getSelectedIndex()==2)
					l3 =1;
				else
					l4=1;
				
			}
		});
		cbListType.setModel(new DefaultComboBoxModel(new String[] {"Sorted List", "Almost Sorted List", "Random Sorted List", "Reverse Sorted List"}));
		
		JSlider slider = new JSlider();
		
		slider.setToolTipText("List Size");
		slider.setValue(24500);
		slider.setMaximum(50000);
		slider.setMinimum(1000);
		
		JLabel lblStats = new JLabel("Results will appear here");
		
		JLabel lblListSize = new JLabel("List Size (1000-50,000)");

		JComboBox cbTrials2 = new JComboBox();
		JComboBox cbTrials = new JComboBox();
		
		JButton btnStart = new JButton("Start");
		JButton btnCompare = new JButton("Bottom Compared to Top");

		JLabel lblComparisons = new JLabel("Comparisons");
		JLabel lblMovements = new JLabel("Movements");
		JLabel lblTime = new JLabel("Time");
		JLabel lblSize = new JLabel("");
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				start();
				lblStats.setText("Trial: "+history[iteration-1].getTrial());
				lblComparisons.setText("Comparisons: "+history[iteration-1].getComparisons());
				lblMovements.setText("Movements: "+history[iteration-1].getMovements());
				lblTime.setText("Time: "+history[iteration-1].getTime()+" nanoseconds");
				
				cbTrials.addItem(""+iteration);
				cbTrials2.addItem(""+iteration);
				int z = a1+a2+a3+a4+a5+a6+l1+l2+l3+l4;
				if(z>=9)
					lblWinner.setText("The Winner is Quick Sort (check analysis)");
			}
			
		});
		btnCompare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStats.setText("Trial "+(cbTrials2.getSelectedIndex()+1)+" Compares to "+(cbTrials.getSelectedIndex()+1)+" as follows:");
				int x =compare(history[cbTrials.getSelectedIndex()].getComparisons(),history[cbTrials2.getSelectedIndex()].getComparisons());
				lblComparisons.setText("Comparisons: "+x+"% of trial "+(cbTrials.getSelectedIndex()+1));
				x =compare(history[cbTrials.getSelectedIndex()].getMovements(),history[cbTrials2.getSelectedIndex()].getMovements());
				lblMovements.setText("Movements: "+x+"% of trial "+(cbTrials.getSelectedIndex()+1));
				
				
				x =compare(history[cbTrials.getSelectedIndex()].getTime(),history[cbTrials2.getSelectedIndex()].getTime());
				lblTime.setText("Time: "+x+"% of trial "+(cbTrials.getSelectedIndex()+1));
				x =compare(history[cbTrials.getSelectedIndex()].getListSize(),history[cbTrials2.getSelectedIndex()].getListSize());
				lblSize.setText("Size: "+x+"% of trial "+(cbTrials.getSelectedIndex()+1));
				
				
				
			}
		});
		slider.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lblListSize.setText(""+slider.getValue());
				listSize = slider.getValue();
			}
		});
		btnInsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alg = 1;
				a1 = 1;//im going to assume that the user clicked on this and selected it as their desired algorithim, i do not want to find a work around them clicking all the algorithims and then finding the winner
				btnSelection.setBackground(Color.WHITE);
				btnInsertion.setBackground(Color.LIGHT_GRAY);
				btnQuick.setBackground(Color.WHITE);
				btnMerge.setBackground(Color.WHITE);
				btnHeap.setBackground(Color.WHITE);
				btnRadix.setBackground(Color.WHITE);
			}
		});
		btnSelection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alg = 2;
				a2 = 1;
				btnSelection.setBackground(Color.LIGHT_GRAY);
				btnInsertion.setBackground(Color.WHITE);
				btnQuick.setBackground(Color.WHITE);
				btnMerge.setBackground(Color.WHITE);
				btnHeap.setBackground(Color.WHITE);
				btnRadix.setBackground(Color.WHITE);
			}
			}
		);
		btnQuick.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alg = 3;
				a3 = 1;
				btnSelection.setBackground(Color.WHITE);
				btnInsertion.setBackground(Color.WHITE);
				btnQuick.setBackground(Color.LIGHT_GRAY);
				btnMerge.setBackground(Color.WHITE);
				btnHeap.setBackground(Color.WHITE);
				btnRadix.setBackground(Color.WHITE);
			}
		});
		btnHeap.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alg = 4;
				a4 = 1;
				btnSelection.setBackground(Color.WHITE);
				btnInsertion.setBackground(Color.WHITE);
				btnQuick.setBackground(Color.WHITE);
				btnMerge.setBackground(Color.WHITE);
				btnHeap.setBackground(Color.LIGHT_GRAY);
				btnRadix.setBackground(Color.WHITE);
			}
		});
		btnMerge.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alg = 5;	
				a5 = 1;
				btnSelection.setBackground(Color.WHITE);
				btnInsertion.setBackground(Color.WHITE);
				btnQuick.setBackground(Color.WHITE);
				btnMerge.setBackground(Color.LIGHT_GRAY);
				btnHeap.setBackground(Color.WHITE);
				btnRadix.setBackground(Color.WHITE);
					
			}
		});
		btnRadix.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				alg = 6;
				a6 = 1;
				btnSelection.setBackground(Color.WHITE);
				btnInsertion.setBackground(Color.WHITE);
				btnQuick.setBackground(Color.WHITE);
				btnMerge.setBackground(Color.WHITE);
				btnHeap.setBackground(Color.WHITE);
				btnRadix.setBackground(Color.LIGHT_GRAY);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCompare, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
							.addGap(71)
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(166))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnQuick, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnMerge, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnHeap, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnRadix, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnInsertion, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnSelection, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAlg, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cbTrials, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbTrials2, Alignment.LEADING, 0, 165, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(204)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblWinningAlgorithimDisplay, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(cbListType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(162))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(120)
										.addComponent(lblListSize)
										.addContainerGap())
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(9)
										.addComponent(lblWinner, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblComparisons, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblStats, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(lblMovements, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(71))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWinner, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlg))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWinningAlgorithimDisplay)
						.addComponent(btnSelection))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnInsertion)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnQuick))
								.addComponent(cbListType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnMerge)
								.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblListSize, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnHeap)))
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRadix)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbTrials, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbTrials2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStats)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblComparisons)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMovements)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSize)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCompare)
						.addComponent(btnStart))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	
	
	//Stuff from the original Main
	//
	//
	//
	//
	//
	//
	//
	//
	
	
	public static void start() {
		
		int[] list = new int[listSize];
		
		if(listType==0)
			list = generateOrderedList(listSize);
		else if(listType==3)
			list = generateReverseOrderedList(listSize);
		else if(listType==1)
			list = generateAlmostOrderedList(listSize);
		else
			list = generateRandomList(listSize);
		System.out.println("List generated");
		
		
		
		
		if(alg==1) {
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
			QuickSort.quickSort(list);
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
		printArray(list);
		
		history[iteration] = new Trial();
		history[iteration].setMovements(movements);
		history[iteration].setComparisons(comparisons);
		history[iteration].setTime(totalTime);
		history[iteration].setAlg(alg);
		history[iteration].setListSize(listSize);
		history[iteration].setTrial(iteration+1);
		iteration++;
		
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
	 
	 static void printArray(int arr[]) 
	 { 
	     int n = arr.length; 
	     for (int i=0; i<n; i++) {
	    	 System.out.print(arr[i]+" "); 
	    	 System.out.println();
	     }
	 } 	 
	 public static int compare(long num1, long num2)
	 {
		 
		 int val=0;
		 double d;
		 d=num2/(num1+1-1.0);//num2 as the numerator gives us it's percentage compared to the denominator, the +1-2.0 is to make it a double
		 d*=100;
		 val = (int)d;
		 return val;
	 }
}

