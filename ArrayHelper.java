import java.util.Random;

public class ArrayHelper {

  // arrays
  int[] unsortedArr;
  int[] sortedArr;

  // generate an array with random numbers
  public static int[] generateArray(int size) {
    Random rd = new Random();

    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
        arr[i] = rd.nextInt(20000) - 10000;
    }

    return arr;
  }

  // turn an array into a string
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