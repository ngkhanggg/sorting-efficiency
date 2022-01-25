public class BubbleSort extends Sorter {
    public String getName() {
        return "Bubble Sort";
    }
    
    public int[] internalSort(int[] unsortedArr, String order) {
        // clone the unsorted array
        int[] arr = unsortedArr.clone();

        // algorithm
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp = arr[j];

                // ascending order
                if (order.equals("Ascending")) {
                    if (arr[j] > arr[j + 1]) {
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    this.comparisons++;
                }

                // descending order
                else {
                    if (arr[j] < arr[j + 1]) {
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    this.comparisons++;
                }
            }
        }

        return arr;
    }
}
