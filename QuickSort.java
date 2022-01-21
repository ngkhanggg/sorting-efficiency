


public class QuickSort extends Sorter {

  //This version of the method just sorts the array. It existing allows isRecordingTime, isRecordingIterations, recordingName to have default parameters
  public int[] sort(int[] unsortedData, String order) {
    
    int[] dataToSort = unsortedData.clone();

    long timerStart = System.currentTimeMillis(); // starting time

    this.lastNumSortComparisons = 0;

    recursiveSort(dataToSort, 0, dataToSort.length-1, order);

    long timerEnd = System.currentTimeMillis(); // ending time

    this.lastSortSpeed = timerEnd - timerStart;
    

    return dataToSort;
  }

  private void recursiveSort(int[] dataToSort, int left, int right, String order) {
    
    // Left should not be to the right of right. If it is, don't run the function. If Left and right are equal, that means its asking for a singe entry, which is sorted already so nothing needs to be done.
    if (left >= right) {
      return;
    }

    //The number that will divide the array into higher than and lower than numbers
    int partition = dataToSort[(int)((left+right) / 2)];

    //The counter that will search for numbers higher than the partition
    int frontCounter = left;

    //The counter that will search for numbers lower than the partition
    int backCounter = right;
    int temp;

    //If the counters pass each other, we must have looked at the entire array
    while (frontCounter < backCounter) {
      this.lastNumSortComparisons++;

      if (order == "ascending") {
        //Find a number on the left side that is too big (Or equal to the partition)
        while (dataToSort[frontCounter] < partition) {
          this.lastNumSortComparisons++;
          frontCounter++;
        }
        this.lastNumSortComparisons++;

        //Find a number on the right side that is too small (Or equal to the partition)
        while (dataToSort[backCounter] > partition) {
          this.lastNumSortComparisons++;
          backCounter--;
        }
        this.lastNumSortComparisons++;
      } else if (order == "descending") {
        //Find a number on the left side that is too big (Or equal to the partition)
        while (dataToSort[frontCounter] > partition) {
          this.lastNumSortComparisons++;
          frontCounter++;
        }
        this.lastNumSortComparisons++;

        //Find a number on the right side that is too small (Or equal to the partition)
        while (dataToSort[backCounter] < partition) {
          this.lastNumSortComparisons++;
          backCounter--;
        }
        this.lastNumSortComparisons++;
      }
      
      
      //Don't do any swapping if the counters have passed each other
      this.lastNumSortComparisons++;
      if (frontCounter <= backCounter) {        
        temp = dataToSort[frontCounter];
        dataToSort[frontCounter] = dataToSort[backCounter];
        dataToSort[backCounter] = temp;

        //The counters need to move forward so they don't get stuck infinitely swapping two values equal to the partition
        frontCounter++;
        backCounter--;
      }
      this.lastNumSortComparisons++;
    }
    this.lastNumSortComparisons++;
    
    //Sort the value left of the partition
    recursiveSort(dataToSort, frontCounter, right, order);

    //Sort the values right of the partition
    recursiveSort(dataToSort, left, backCounter, order);

    return;
  }
}
