import java.util.Random;

/**
   This class compares the efficiency of Selection Sort, Insertion Sort,
   Shell Sort, Other Shell Sort, Bubble Sort, and Better Bubble Sort.

   @author 
*/

public class SortComparisons
{
	private int counter;
	private Random r;
	private int[] list1, list2, list3, list4, list5, list6;

	public SortComparisons()
	{
		counter = 0;
		r = new Random();
		testComparisons();
	}

	/** Tests the number of comparisons between the different sorting algorithms. */
	public void testComparisons()
	{
		for (int x = 2; x <= 4096; x *= 2)
		{
			populateLists(x);
			System.out.println("With arrays of size " + x + "...");
			counter = 0;
			selectionSort(list1, 0, x - 1);
			System.out.println("Selection Sort makes " + counter + " comparisons");
			counter = 0;
			insertionSort(list2, 0, x - 1);
			System.out.println("Insertion Sort makes " + counter + " comparisons");
			counter = 0;
			shellSort(list3, 0, x - 1);
			System.out.println("Shell Sort makes " + counter + " comparisons");
			counter = 0;
			otherShellSort(list4, 0, x - 1);
			System.out.println("A modified Shell Sort makes " + counter + " comparisons");
			counter = 0;
			bubbleSort(list5, 0, x - 1);
			System.out.println("A Bubble Sort makes " + counter + " comparisons");
			counter = 0;
			betterBubbleSort(list6, 0, x - 1);
			System.out.println("A better Bubble Sort makes " + counter + " comparisons");
         System.out.println();
		} // end for
	} // end testComparisons

	/** Fills each list with random integers in the same order.
		@param size  The number of random integers to fill in. 
   */
	public void populateLists(int size)
	{
		list1 = new int[size];
		list2 = new int[size];
		list3 = new int[size];
      list4 = new int[size];
		list5 = new int[size];
      list6 = new int[size];

		int index = 0;
		while (index < size)
		{
			int tempInt = r.nextInt(size);
			list1[index] = tempInt;
			list2[index] = tempInt;
			list3[index] = tempInt;
         list4[index] = tempInt;
			list5[index] = tempInt;
         list6[index] = tempInt;
			index++;
		} // end while
	} // end populateLists

   /** Selection Sort
       Sorts the first n objects in an array into ascending order.
       @param a  An array of Comparable objects.
       @param n  An integer > 0. 
   */
   public void selectionSort(int[] a, int first, int last)
   {

      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method getIndexOfSmallest.


   } // end selectionSort
  
   // Finds the index of the smallest value in a portion of an array a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private int getIndexOfSmallest(int[] a, int first, int last)
   {
      // ADD CODE HERE TO COMPLETE THIS METHOD 


   } // end getIndexOfSmallest

	/** Sorts using the recursive Insertion Sort algorithm.
		@param a	  The array to sort.
		@param first  The index of the first element to sort.
		@param last   The index of the last element to sort. 
   */
	public void insertionSort(int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method insertInOrder.


	} // end insertionSort

	// Inserts an element into the appropriate location in the given
	// array, between first and last.
	private void insertInOrder(int element, int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 


	} // end insertInOrder

	/** Sorts using the Shell Sort algorithm.
		@param a	  The array to sort.
		@param first  The index of the first element to sort.
		@param last   The index of the last element to sort. 
   */
	public void shellSort(int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method incrementalInsertionSort.


	} // end shellSort

   /** Sorts equally spaced elements of an array into
	    ascending order, used for shell sort.
	    @param a  an array of Comparable objects.
	    @param first  An integer >= 0 that is the index of the first
	               array element to consider.
	    @param last   An integer >= first and < a.length that is the
	               index of the last array element to consider.
       @param space  The difference between the indices of the
	               elements to sort.
   */
	private void incrementalInsertionSort(int[] a, int first, int last, int space)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 


	} // end incrementalInsertionSort

	/** Sorts using the modified Shell Sort algorithm.
		@param a	  The array to sort.
		@param first  The index of the first element to sort.
		@param last   The index of the last element to sort. 
   */
	public void otherShellSort(int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the method incrementalInsertionSort.



	} // end otherShellSort
   
	/** Sorts using the Bubble Sort algorithm.
		@param a	  The array to sort.
		@param first  The index of the first element to sort.
		@param last   The index of the last element to sort. 
   */
	public void bubbleSort(int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method order.


	} // end bubbleSort
	
   // Swaps the array the array entries a[i] and a[j] if necessary
	private void order(int[] a, int i, int j)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 


	}  // end order 
   // -------------------------------------------------------------------------------
   
	/** Sorts using a better Bubble Sort algorithm.
		@param a	  The array to sort.
		@param first  The index of the first element to sort.
		@param last   The index of the last element to sort. 
   */
	public void betterBubbleSort(int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method swap.

	}  // end betterBubbleSort

   // Swaps the array entries a[i] and a[j].
   private static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp; 
   } // end swap

	// Tests various sorting methods
   public static void main(String[] args)
	{
		new SortComparisons();
	} // end main
} // end SortComparisons

