/*

REMEMBER TO ADD CHOICES SO THAT THE USER CAN CHOOSE WHICH ORDER (ASCENDING OR DESCENDING) TO SORT

*/

import java.util.Random;

public class Main {

  //If theres time, it might be nice to make this an array of some sort. It would make it easier to expand on, less hard coding.
	private static BubbleSort bubble = new BubbleSort();
	private static SelectionSort selection = new SelectionSort();
	private static QuickSort quick = new QuickSort();

  public static void main(String[] args) {

    // TODO: Set up the GUI

    // TODO: replace 10 with getting user input for the array size
    int unsortedArraySize = 10;

    // initializing unsorted array
    int[] unsortedArr = generateArr(unsortedArraySize);

    // TODO: Ask user for input on ascending or descending order for each sort instead of hard coding. Alternately, there could be one order variable that changes before each sort.
    // The users choices to sort each array ascending or descending
    String bubbleSortOrder = "ascending";
    String selectionSortOrder = "ascending";
    String quickSortOrder = "ascending";

    // Call the sorting algorithms
    // Recording just one of the sorting algorithm outputs as the sorted array
    int[] sortedArr = useSort(unsortedArr, "bubble", bubbleSortOrder);
    useSort(unsortedArr, "selection", selectionSortOrder);
    useSort(unsortedArr, "quick", quickSortOrder);
    System.out.println();

    //Temporary output for the sorting times and comparisons
    System.out.println("BubbleSort ran in " + bubble.getLastExecutionTime() + " milliseconds");
    System.out.println("BubbleSort used " + bubble.getLastNumOfComparisons() + " Comparisons");
    System.out.println();
    System.out.println("SelectionSort ran in " + selection.getLastExecutionTime() + " milliseconds");
    System.out.println("SelectionSort used " + selection.getLastNumOfComparisons() + " Comparisons");
    System.out.println();
    System.out.println("QuickSort ran in " + quick.getLastExecutionTime() + " milliseconds");
    System.out.println("QuickSort used " + quick.getLastNumOfComparisons() + " Comparisons");
    System.out.println();

    // TODO: Change this to outputting the unsorted array to the GUI
    // display all the numbers in the unsorted array
    // for (int num: unsortedArr) {
    //     System.out.print(num + " ");
    // }
    // System.out.println();

    // TODO: Change this to outputting the sorted array to the GUI
    // display all the numbers in the sorted array
    // System.out.println();
    // for (int num: sortedArr) {
    //     System.out.print(num + " ");
    // }

    // TODO: output the time and comparison count data for each sort

  }

	// generate an array with random numbers
  public static int[] generateArr(int length) {
      Random rd = new Random();

      int[] arr = new int[length];

      for (int i = 0; i < arr.length; i++) {
          arr[i] = rd.nextInt(20000) - 10000;
      }
      return arr;
    }

	// use a particular type of sortings using switch
  public static int[] useSort(int[] arr, String type, String order) {
    switch(type) {
      case "bubble":
        return bubble.sort(arr, order);
      case "selection":
        return selection.sort(arr, order);
      case "quick":
        return quick.sort(arr, order);
      default:
        return arr;
    }
  }
}
