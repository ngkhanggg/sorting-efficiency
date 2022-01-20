


public class QuickSort extends Sorter {

  //This version of the method just sorts the array. It existing allows isRecordingTime, isRecordingIterations, recordingName to have default parameters
  public int[] sort(int[] unsortedData, String order) {
    
    int[] dataToSort = unsortedData.clone();

    long timerStart = System.currentTimeMillis(); // starting time

    this.numLastSortComparisons = 0;

    recursiveSort(dataToSort, 0, dataToSort.length-1);

    long timerEnd = System.currentTimeMillis(); // ending time

    this.lastSortSpeed = timerEnd - timerStart;
    

    return dataToSort;
  }

  private void recursiveSort(int[] dataToSort, int left, int right) {
    
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
      this.numLastSortComparisons++;


      //Find a number on the left side that is too big (Or equal to the partition)
      while (dataToSort[frontCounter] < partition) {
        this.numLastSortComparisons++;
        frontCounter++;
      }
      this.numLastSortComparisons++;

      //Find a number on the right side that is too small (Or equal to the partition)
      while (dataToSort[backCounter] > partition) {
        this.numLastSortComparisons++;
        backCounter--;
      }
      this.numLastSortComparisons++;
      
      //Don't do any swapping if the counters have passed each other
      this.numLastSortComparisons++;
      if (frontCounter <= backCounter) {        
        temp = dataToSort[frontCounter];
        dataToSort[frontCounter] = dataToSort[backCounter];
        dataToSort[backCounter] = temp;

        //The counters need to move forward so they don't get stuck infinitely swapping two values equal to the partition
        frontCounter++;
        backCounter--;
      }
      this.numLastSortComparisons++;
    }
    this.numLastSortComparisons++;
    
    //Sort the value left of the partition
    recursiveSort(dataToSort, frontCounter, right);

    //Sort the values right of the partition
    recursiveSort(dataToSort, left, backCounter);

    return;
  }
}
