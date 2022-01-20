


public class BubbleSort extends Sorter {
    public int[] sort(int[] unsortedArr, String order) {
        long start = System.currentTimeMillis(); // starting time

		// count the number of comparisons
        int count = 0;

		// clone/copy elements from the original array
        int[] arr = unsortedArr.clone();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
				int temp = unsortedArr[j];

				if (order.equals("ascending")) {
					if (unsortedArr[j] > unsortedArr[j + 1]) {
						unsortedArr[j] = unsortedArr[j + 1];
						unsortedArr[j + 1] = temp;
					}
				}
				else {
					if (unsortedArr[j] < unsortedArr[j + 1]) {
						unsortedArr[j] = unsortedArr[j + 1];
						unsortedArr[j + 1] = temp;
					}
				}
				
				count++;
            }
        }

        long end = System.currentTimeMillis(); // ending time

		// TEMPPORARY
		// pass the variables to the parent class
		// display duration and comparisons
        super.printExecutionTime(arr.length, end - start);
        System.out.println();
        super.printNumOfComparisons(arr.length, count);

        return arr;
    }
}
