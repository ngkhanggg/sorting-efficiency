public class SelectionSort extends Sorter {
    public String getName() {
        return "Selection Sort";
    }
    
    public int[] internalSort(int[] unsortedArr, String order) {
        // clone the unsorted array
        int[] arr = unsortedArr.clone();

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

        return arr;
    }
}
