public class QuickSorter implements CanSort {

  //This version of the method just sorts the array. It existing allows isRecordingTime, isRecordingIterations, recordingName to have default parameters
  public void sort(int[] dataToSort) {
    recursiveSort(dataToSort, 0, dataToSort.length-1);
  }

  private void recursiveSort(int[] dataToSort, left, right) {
    
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

      //Find a number on the left side that is too big (Or equal to the partition)
      while (dataToSort[frontCounter] < partition) {
        frontCounter++;
      }

      //Find a number on the right side that is too small (Or equal to the partition)
      while (dataToSort[backCounter] > partition) {
        backCounter--;
      }

      //Don't do any swapping if the counters have passed each other
      if (frontCounter <= backCounter) {
        temp = dataToSort[frontCounter];
        dataToSort[frontCounter] = dataToSort[backCounter];
        dataToSort[backCounter] = temp;

        //The counters need to move forward so they don't get stuck infinitely swapping two values equal to the partition
        frontCounter++;
        backCounter--;
      }
      
    }
    
    //Sort the value left of the partition
    recursiveSort(dataToSort, frontCounter, right);

    //Sort the values right of the partition
    recursiveSort(dataToSort, left, backCounter);

    return;
  }
}
