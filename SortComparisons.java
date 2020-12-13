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
	  for (int i = 0; i < a.length; i++) {
		  int nextSmallestIndex = getIndexOfSmallest(a, first, last);
		  counter++;
		  swap(a, i, nextSmallestIndex);
	  }


   } // end selectionSort
  
   // Finds the index of the smallest value in a portion of an array a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private int getIndexOfSmallest(int[] a, int first, int last)
   {
	  // ADD CODE HERE TO COMPLETE THIS METHOD 
	  int min = a[first];
	  int indexOfMin = first;
	  for (int i = first + 1; i <= last; i++) {
		counter++;
		  if (a[i] < min) {
			  min = a[i];
			  indexOfMin = i;
		  }
	  }
	  return indexOfMin;
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
	  if (first < last) {
		  counter++;
		  insertionSort(a, first, last - 1);
		  insertInOrder(a[last], a, first, last-1);
	  }


	} // end insertionSort

	// Inserts an element into the appropriate location in the given
	// array, between first and last.
	private void insertInOrder(int element, int[] a, int first, int last)
	{
	  // ADD CODE HERE TO COMPLETE THIS METHOD 
	  if (element >= a[last]) {
		  counter++;
		  a[last+1] = element;
	  } else if (first < last) {
		  counter++;
		  a[last+1] = a[last];
		  insertInOrder(element, a, first, last-1);
	  } else {
		  counter++;
		  a[last+1] = a[last];
		  a[last] = element;
	  }


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
	  int n = a.length;
	  int space = n/2;
	  while (space > 0) {
		  counter++;
		  for (int i = first; i < first + space - 1; i++) {
			  counter++;
			  incrementalInsertionSort(a, first, last, space);
		  }
		  space = space / 2;
	  }

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
	  for (int unsorted = first + space; unsorted < last; unsorted += space) {
		  counter++;
		  int nextToInsert = a[unsorted];
		  int index = unsorted - space;
		  while (index >= first && nextToInsert < a[index]) {
			  counter++;
			  a[index + space] = a[index];
			  index = index - space;
		  }
		  a[index + space] = nextToInsert;
	  }


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
	  int n = a.length;
	  int space = n/2;
	  while (space > 0) {
		if (space % 2 == 0) {
			space = space + 1;
		}
		  counter++;
		  for (int i = first; i < first + space - 1; i++) {
			  counter++;
			  incrementalInsertionSort(a, first, last, space);
		  }
		  space = space / 2;
	  }



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
	  for (int i = first; i < a.length - 1; i++) {
		  counter++;
		  for (int j = first; j < a.length - i - 1; j++) {
			  counter++;
			  if (a[j] > a[j+1]) { 
				  counter++;
				  order(a, j, j+1);
				  counter++;
			  }
		  }
	  }

	} // end bubbleSort
	
   // Swaps the array the array entries a[i] and a[j] if necessary
	private void order(int[] a, int i, int j)
	{
	  // ADD CODE HERE TO COMPLETE THIS METHOD 

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;


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
	  boolean swapped;
	  for (int i = first; i < a.length - 1; i++) {
		  swapped = false;
		counter++;
		for (int j = first; j < a.length - i - 1; j++) {
			counter++;
			if (a[j] > a[j+1]) { 
				counter++;
				swap(a, j, j+1);
				swapped = true;
			}
		}
		if (!swapped) {
			break;
		}
	}


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

