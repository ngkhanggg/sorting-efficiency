


public class SelectionSort extends Sorter {
  public int[] sort(int[] unsortedArr, String order) {

    // starting time
    long start = System.currentTimeMillis();

    // clone/copy elements from the original array
    int[] arr = unsortedArr.clone();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int temp = arr[i];

        if (order.equals("ascending")) {
          this.lastNumSortComparisons++;
          if (arr[i] > arr[j]) {
            this.lastNumSortComparisons++;
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
        else {
          this.lastNumSortComparisons++;
          if (arr[i] < arr[j]) {
            this.lastNumSortComparisons++;
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
      }
    }

    // ending time
    long end = System.currentTimeMillis();

    // Record time elapsed
    this.lastSortSpeed = end - start;

    return arr;
  }
}
