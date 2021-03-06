import java.util.Random;

/**
   This class compares the efficiency of Selection Sort, Insertion Sort,
   Shell Sort, Other Shell Sort, Bubble Sort, and Better Bubble Sort.

   @author modified by David Weinstein
   Date: 12/13/2020

   Pseudocode:
   1. Initialize class field variables for counter, random, and empty arrays to test
   2. Constructor sets counter to 0, a new Random r, and calls testComparisons()
   3. testComparisons will popuate lists of size 2 up to 4096 by multiplicating, and also display reults of sorts
   4. Sorting method selectinSort implementation
   5. Sorting helper method getIndexOfSmallest
   6. Sorting method insertionSort implemented
   7. Sorting helper method insertInOrder
   8. Sorting method shellSort implemented
   9. Sorting helper method incrementalInsertInOrder
   10. Sorting method otherShellSort implemented
   11. Sorting method bubbleSort implemented
   12. Sorting helper method order 
   13. Sorting method betterBubbleSort implemented
   14. Sorting helper method swap
*/

public class SortComparisonsWeinstein
{
	private int counter;
	private Random r;
	private int[] list1, list2, list3, list4, list5, list6;

    // constuctor
	public SortComparisonsWeinstein()
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
       @param first first index in array
       @param last last index in array 
   */
   public void selectionSort(int[] a, int first, int last)
   {

      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // using the private method getIndexOfSmallest.
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
	  for (int i = 0; i < a.length; i++) {
		  int nextSmallestIndex = getIndexOfSmallest(a, first, last);
		  counter++;
		  swap(a, i, nextSmallestIndex);
      }
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)


   } // end selectionSort
  
   // Finds the index of the smallest value in a portion of an array a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private int getIndexOfSmallest(int[] a, int first, int last)
   {
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)
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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
	  if (first < last) {
		  counter++;
		  insertionSort(a, first, last - 1);
		  insertInOrder(a[last], a, first, last-1);
      }
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)


	} // end insertionSort

	// Inserts an element into the appropriate location in the given
	// array, between first and last.
	private void insertInOrder(int element, int[] a, int first, int last)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)

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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)

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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)


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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)


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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)
	} // end bubbleSort
	
   // Swaps the array the array entries a[i] and a[j] if necessary
	private void order(int[] a, int i, int j)
	{
      // ADD CODE HERE TO COMPLETE THIS METHOD 
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
		int temp = a[i];
		a[i] = a[j];
        a[j] = temp;
        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)

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
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
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
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)

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
		new SortComparisonsWeinstein();
	} // end main
} // end SortComparisonsWeinstein

