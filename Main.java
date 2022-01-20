import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArr = generateArr(9999); // initialize unsorted array

		// display all the numbers in the unsorted array
        // for (int num: unsortedArr) {
        //     System.out.print(num + " ");
        // }

		// initialize sorted array
        int[] sortedArr1 = useSort("selection", unsortedArr);
		System.out.println();
        int[] sortedArr2 = useSort("bubble", unsortedArr);



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
    public static int[] useSort(String type, int[] arr) {
        switch(type) {
          case "selection":
				    System.out.println("Selection Sort");
            SelectionSort selection = new SelectionSort();
            return selection.sort(arr);
          case "bubble":
            System.out.println("Bubble Sort");
            BubbleSort bubble = new BubbleSort();
            return bubble.sort(arr);
          case "quick":
            System.out.println("Quick Sort");
            QuickSort quick = new QuickSort();
            return quick.sort(arr);
          default:
            return arr;
        }
    }
}
