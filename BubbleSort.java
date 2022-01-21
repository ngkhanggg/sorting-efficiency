


public class BubbleSort extends Sorter {
    public int[] sort(int[] unsortedArr, String order) {
        long start = System.currentTimeMillis(); // starting time

		// count the number of comparisons
        int count = 0;

		// clone/copy elements from the original array
        int[] arr = unsortedArr.clone();

        for (int i = 0; i < arr.length - 1; i++) {
          for (int j = 0; j < arr.length - i - 1; j++) {
      
			      int temp = arr[j];
      
			    	if (order.equals("ascending")) {
				    	if (arr[j] > arr[j + 1]) {
					     	arr[j] = arr[j + 1];
					    	arr[j + 1] = temp;
				 	}
				}
			    	else {
				    	if (arr[j] < arr[j + 1]) {
					  	  arr[j] = arr[j + 1];
						    arr[j + 1] = temp;
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
