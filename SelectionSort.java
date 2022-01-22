


public class SelectionSort extends Sorter {
  public int[] internalSort(int[] unsortedArr, String order) {

    // clone/copy elements from the original array
    int[] arr = unsortedArr.clone();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {

        // Used for swapping
        int temp = arr[i];

        if (order.equals("ascending")) {

          //If this value is smaller than our current smallest value, move it to index j
          this.lastNumSortComparisons++;
          if (arr[i] > arr[j]) {
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
        else {

          //If this value is bigger than our current smallest value, move it to index j
          this.lastNumSortComparisons++;
          if (arr[i] < arr[j]) {
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
      }
    }

    return arr;
  }
}
