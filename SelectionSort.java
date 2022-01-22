public class SelectionSort extends Sorter {
    public String getName() {
        return "Selection Sort";
    }
    
    public int[] sort(int[] unsortedArr, String order) {
        // clone the unsorted array
        int[] arr = unsortedArr.clone();

        long start = System.currentTimeMillis(); // start time

        this.comparisons = 0;

        // algorithm
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];

                // ascending order
                if (order.equals("Ascending")) {
                    if (arr[i] > arr[j]) {
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                    this.comparisons++;
                }

                // descending order
                else {
                    if (arr[i] < arr[j]) {
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                    this.comparisons++;
                }
            }
        }

        long end = System.currentTimeMillis(); // end time

        this.executionTime = end - start; // duration

        return arr;
    }
}
