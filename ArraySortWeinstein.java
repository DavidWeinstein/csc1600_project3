/**
   A class of static sorting algorithms (only countingSort is included here).
   @author David Weinstein 
   Date: 12/13/2020

   Pseudocode: 
   1. Create array for count with length of max + 1.
   2. Populate array count of each integer
   3. Position countArray so that positions in final array are obtained
   4. Modify original array.

 */
 
public class ArraySortWeinstein 
{
	/** Sorts an array of postive integers that lie within the range 0 to max.
		@param a    The array.
		@param max  The largest value in the array. 
   */
	public static void countingSort(int[] a, int max)
	{
      // ======= ADD CODE HERE TO SORT THE ARRAY =======
      // >>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>> (Beginning of the code added)
      // count array of max + 1 size
	  int[] countArray = new int[max + 1];

      // count frequency for each item in array
	  for (int i = 0; i < a.length; i++) {
		  countArray[a[i]]++;
      }
      
      // modify so array positions are obtained 
	  for (int i = 1; i <= max; i++) {
		  countArray[i] += countArray[i-1];
	  }

      // modify original array with count array
	  int j = 0;
	  for (int i = 0; i <= max; i++) {
		  while (j < countArray[i]) {
			  a[j++] = i;
		  }
      }
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< (End of the code added)
      

	} // end countingSort

	public static void main(String[] args) 
	{
		int[] array = {2, 8, 4, 10, 15, 0, 4, 8, 2, 2, 0, 15, 10};

		System.out.println("The array before sorting:");
		for (int i = 0; i < array.length; i++) 
			System.out.print(array[i]  + " ");
		System.out.println();

		countingSort(array, 15);

		System.out.println("\nThe array after sorting:");
		for (int i = 0; i < array.length; i++) 
			System.out.print(array[i]  + " ");
		System.out.println();
	}  // end main

} // end ArraySortWeinstein

/*
The array before sorting:
2 8 4 10 15 0 4 8 2 2 0 15 10 

The array after sorting:
0 0 2 2 2 4 4 8 8 10 10 15 15 

 */
