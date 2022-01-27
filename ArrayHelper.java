// Helper class which contains all the array related variables and methods that the GUI needs to use

import java.util.Random;

public class ArrayHelper {

  // arrays
  int[] unsortedArr;
  int[] sortedArr;

  // generate an array of specified size with random numbers from -10000 to 10000
  public int[] generateArray(int size) {
    Random rd = new Random();

    int[] arr = new int[size];

    // Populate the array
    for (int i = 0; i < size; i++) {
      arr[i] = rd.nextInt(20001) - 10000;
    }

    return arr;
  }

  // Return an array as a string
  public String arrayToString(int[] arr) {
    String s = "";

    for (int i = 0; i < arr.length - 1; i++) {
        s += arr[i] + ", ";
    }
    s += arr[arr.length - 1];
    
    return s;
  }

  public void setUnsortedArray(int[] arr) {
    unsortedArr = arr;
  }

  public void setSortedArray(int[] arr) {
    sortedArr = arr;
  }

  public int[] getUnsortedArray() {
    return unsortedArr;
  }

  public int[] getSortedArray() {
    return sortedArr;
  }
}