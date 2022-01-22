


public class BubbleSort extends Sorter {
  public int[] internalSort(int[] unsortedArr, String order) {

    // clone/copy elements from the original array
    int[] arr = unsortedArr.clone();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        // Store this in case we need to swap later
        int temp = arr[j];
  
        if (order.equals("ascending")) {
          // Swap current and next entry if current entry is bigger than next entry
          this.lastNumSortComparisons++;
          if (arr[j] > arr[j + 1]) {
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
        else {
          // Swap current and next entry if current entry is smaller than next entry
          this.lastNumSortComparisons++;
          if (arr[j] < arr[j + 1]) {
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
    }

    return arr;
  }
}
