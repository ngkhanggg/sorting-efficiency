/*

REMEMBER TO ADD CHOICES SO THAT THE USER CAN CHOOSE WHICH ORDER (ASCENDING OR DESCENDING) TO SORT

*/

import java.util.Random;

public class Main {
	private static BubbleSort bubble = new BubbleSort();
	private static SelectionSort selection = new SelectionSort();
	private static QuickSort quick = new QuickSort();

    public static void main(String[] args) {
        int[] unsortedArr = generateArr(9999); // initialize unsorted array

		// display all the numbers in the unsorted array
        // for (int num: unsortedArr) {
        //     System.out.print(num + " ");
        // }

		// initialize sorted array
        int[] sortedArr1 = useSort(unsortedArr, "bubble", "ascending");
		System.out.println();
        int[] sortedArr2 = useSort(unsortedArr, "selection", "descending");

		// add an empty line
        // System.out.println();

		// display all the numbers in the sorted array
        // for (int num: sortedArr) {
        //     System.out.print(num + " ");
        // }
    }

	// generate an array with random numbers
    public static int[] generateArr(int length) {
        Random rd = new Random();

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(99) + 1;
        }

        return arr;
    }

	// use a particular type of sortings using switch
    public static int[] useSort(int[] arr, String type, String order) {
        switch(type) {
			case "bubble":
				System.out.println("Bubble Sort");
				return bubble.sort(arr, order);
			case "selection":
				System.out.println("Selection Sort");
				return selection.sort(arr, order);
			case "quick":
				System.out.println("Quick Sort");
				return quick.sort(arr, order);
			default:
				return arr;
        }
    }
}
