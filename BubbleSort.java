public class BubbleSort extends Sorter {
	public int[] sort(int[] unsortedArr) {
		long start = System.currentTimeMillis(); // starting time

		// count the number of comparisons
        int count = 0;

		// clone/copy elements from the original array
        int[] arr = unsortedArr.clone();

        for (int i = 0; i < unsortedArr.length - 1; i++) {
			for (int j = 0; j < unsortedArr.length - i - 1; j++) {
				count++;
				if (unsortedArr[j] > unsortedArr[j + 1]) {
					int temp = unsortedArr[j];
					unsortedArr[j] = unsortedArr[j + 1];
					unsortedArr[j + 1] = temp;
				}
			}
		}

        long end = System.currentTimeMillis(); // ending time

		// pass the variables to the parent class
		// display duration and comparisons
        super.printExecutionTime(arr.length, end - start);
        System.out.println();
        super.printNumOfComparisons(arr.length, count);

        return arr;
	}
}