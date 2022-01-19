import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArr = generateArr(99); // initialize unsorted array

		// display all the numbers in the unsorted array
        for (int num: unsortedArr) {
            System.out.print(num + " ");
        }

		// initialize sorted array
        int[] sortedArr = useSort("selection", unsortedArr);

		// add an empty line
        System.out.println();

		// display all the numbers in the sorted array
        for (int num: sortedArr) {
            System.out.print(num + " ");
        }
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
                SelectionSort sort = new SelectionSort();
                return sort.sort(arr);
            default:
                return arr;
        }
    }
}
