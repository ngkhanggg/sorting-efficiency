public class QuickSort extends Sorter {
  public String getName() {
        return "Quick Sort";
    }
  
  public int[] internalSort(int[] unsortedArr, String order) {
    int[] arr = unsortedArr.clone();

    recursiveSort(arr, 0, arr.length-1, order);

    return arr;
  }

  private void recursiveSort(int[] dataToSort, int left, int right, String order) {
    
    // Left should not be to the right of right. If it is, don't run the function. If Left and right are equal, that means its asking for a singe entry, which is sorted already so nothing needs to be done.
    if (left >= right) {
      return;
    }

    //The number that will divide the array into higher than and lower than numbers
    int partition = dataToSort[(int)((left+right) / 2)];

    //The counter that will search for numbers to put after the partition
    int frontCounter = left;

    //The counter that will search for numbers to put before the partition
    int backCounter = right;

    // Used during swaps
    int temp;

    //If the counters pass each other, we must have looked at the entire array already
    while (frontCounter < backCounter) {

      if (order.equals("ascending")) {

        //Find a number on the left side that is too big (Or equal to the partition)
        while (dataToSort[frontCounter] < partition) {
          this.comparisons++;
          frontCounter++;
        }
        this.comparisons++;

        //Find a number on the right side that is too small (Or equal to the partition)
        while (dataToSort[backCounter] > partition) {
          this.comparisons++;
          backCounter--;
        }
        this.comparisons++;

      } else if (order.equals("descending")) {
        
        //Find a number on the left side that is too big (Or equal to the partition)
        while (dataToSort[frontCounter] > partition) {
          this.comparisons++;
          frontCounter++;
        }
        this.comparisons++;

        //Find a number on the right side that is too small (Or equal to the partition)
        while (dataToSort[backCounter] < partition) {
          this.comparisons++;
          backCounter--;
        }
        this.comparisons++;
      }
      
      
      //Don't do any swapping if the counters have passed each other
      this.comparisons++;
      if (frontCounter <= backCounter) {        
        temp = dataToSort[frontCounter];
        dataToSort[frontCounter] = dataToSort[backCounter];
        dataToSort[backCounter] = temp;

        //The counters need to move forward so they don't get stuck infinitely swapping two values equal to the partition
        frontCounter++;
        backCounter--;
      }
    }
    this.comparisons++;
    
    //Sort the value left of the partition
    recursiveSort(dataToSort, frontCounter, right, order);

    //Sort the values right of the partition
    recursiveSort(dataToSort, left, backCounter, order);

    return;
  }
}
