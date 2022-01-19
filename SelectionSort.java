public class SelectionSort extends Sorter {
    public int[] sort(int[] unsortedArr) {
        long start = System.currentTimeMillis(); // starting time

        int count = 0; // count the number of comparisons

		// clone/copy elements from the original array
        int[] arr = unsortedArr.clone();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                count++;
            }
        }

        long end = System.currentTimeMillis(); // ending time

		// pass the variables to the parent class
        super.printExecutionTime(arr.length, end - start);
        System.out.println();
        super.printNumOfComparisons(arr.length, count);

        return arr;
    }
}
