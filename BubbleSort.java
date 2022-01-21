


public class BubbleSort extends Sorter {
  public int[] sort(int[] unsortedArr, String order) {
    long start = System.currentTimeMillis(); // starting time

    // clone/copy elements from the original array
    int[] arr = unsortedArr.clone();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
  
        int temp = arr[j];
  
        if (order.equals("ascending")) {
          this.lastNumSortComparisons++;
          if (arr[j] > arr[j + 1]) {
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
        else {
          this.lastNumSortComparisons++;
          if (arr[j] < arr[j + 1]) {
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
    }

    long end = System.currentTimeMillis(); // ending time

    this.lastSortSpeed = end - start;

    return arr;
  }
}
