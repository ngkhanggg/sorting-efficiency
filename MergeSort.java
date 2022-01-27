// Sorter subclass. Sorts using the merge sort algorithm

public class MergeSort extends Sorter {
  public String getName() {
      return "Merge Sort";
  }
  
  // This step is here so that later any additions can be made without dealing with recursion
  public int[] internalSort(int[] unsortedArr, String order) {
    return recursiveSort(unsortedArr, order);
  }

  // Algorithm
  public int[] recursiveSort(int[] unsortedArr, String order) {
      
    // Base case: We have broken the array down to a single element
    if (unsortedArr.length <= 1) {
      return unsortedArr;
    }

    // For splitting the array evenly in two
    int midpoint = unsortedArr.length / 2;

    // Left is the front half of the array, right is the back half.
    int[] left = new int[midpoint];
    int[] right;

    // Make right the correct length
    if (unsortedArr.length % 2 == 0) {
      right = new int[midpoint];
    } else {
      right = new int[midpoint + 1];
    }

    // Populate left and right with their values from the unsplit array
    for (int i = 0;i < left.length;i++) {
      left[i] = unsortedArr[i];
    }
    for (int i = 0;i < right.length;i++) {
      right[i] = unsortedArr[i+midpoint];
    }

    // Make an empty array for the sorted version of our unsorted array
    int[] result = new int[unsortedArr.length];

    // Sort our left and right halves
    left = recursiveSort(left, order);
    right = recursiveSort(right, order);

    // Combine our sorted halves to get our enitre sorted array
    result = merge(left, right, order);

    return result;
  }

  // Takes two arrays and makes them into a single sorted array
  public int[] merge(int[] left, int[] right, String order) {
    
    // The array created by merging the two arrays
    int[] result = new int[left.length + right.length];

    // The counter for the merged array
    int mergeIndex = 0;

    // The counter for the left array
    int leftIndex = 0;

    // The conuter for the right array
    int rightIndex = 0;

    // While either array still has items left to add
    while (leftIndex < left.length || rightIndex < right.length) {

      // If both arrays have items left to add
      if (leftIndex < left.length && rightIndex < right.length) {
        if (order.equals("Ascending")) {

          // Choose the array whose item is smaller
          this.comparisons++;
          if (left[leftIndex] < right[rightIndex]) {
            result[mergeIndex] = left[leftIndex];
            leftIndex++;
          } else {
            result[mergeIndex] = right[rightIndex];
            rightIndex++;
          }
        } else {
          
          // Choose the array whose item is bigger
          this.comparisons++;
          if (left[leftIndex] > right[rightIndex]) {
            result[mergeIndex] = left[leftIndex];
            leftIndex++;
          } else {
            result[mergeIndex] = right[rightIndex];
            rightIndex++;
          }
        }
      }

      // If only the left array has items, add an item from it
      else if (leftIndex < left.length) {
        result[mergeIndex] = left[leftIndex];
        leftIndex++;
      }
      
      // If only the right array has items, add an item from it
      else if (rightIndex < right.length) {
        result[mergeIndex] = right[rightIndex];
        rightIndex++;
      }

      // Onto the next index of the merged array
      mergeIndex++;
    }

    return result;
  }
}
