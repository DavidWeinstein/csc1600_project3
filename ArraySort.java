/**
   A class of static sorting algorithms (only countingSort is included here).
   @author 
 */
 
public class ArraySort 
{
	/** Sorts an array of postive integers that lie within the range 0 to max.
		@param a    The array.
		@param max  The largest value in the array. 
   */
	public static void countingSort(int[] a, int max)
	{
	  // ======= ADD CODE HERE TO SORT THE ARRAY =======
	  int[] countArray = new int[max + 1];

	  for (int i = 0; i < a.length; i++) {
		  countArray[a[i]]++;
	  }
	  for (int i = 1; i <= max; i++) {
		  countArray[i] += countArray[i-1];
	  }

	  int j = 0;
	  for (int i = 0; i <= max; i++) {
		  while (j < countArray[i]) {
			  a[j++] = i;
		  }
	  }
      

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

} // end ArraySort

/*
The array before sorting:
2 8 4 10 15 0 4 8 2 2 0 15 10 

The array after sorting:
0 0 2 2 2 4 4 8 8 10 10 15 15 

 */
