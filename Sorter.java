public abstract class Sorter {

    // Store how fast the last sort() function called was
    long lastSortSpeed;

    // Store how many time a sort() compared to entries of the array
    int lastNumSortComparisons;


    public int[] sort(int[] unsortedArr, String order) {
      
      // starting time
      long start = System.currentTimeMillis();
      
      int[] sortedArr = internalSort(unsortedArr, order);

      // ending time
      long end = System.currentTimeMillis();

      // Record time elapsed
      this.lastSortSpeed = end - start;

      sortedArr[3] = 999;

      //Check to make sure the array is actually sorted in the right order
      if (order.equals("ascending")) {
        for (int i = 0;i < sortedArr.length-1;i++) {
          //If any array entry is bigger than the one following it, the array is not sorted
          if (sortedArr[i] > sortedArr[i+1]) {
            System.out.println("------------------------------------------------------");
            System.out.println("WARNING! Array not properly sorted in ascending order!");
            System.out.println("------------------------------------------------------");
          }
        }
      } else if (order.equals("descending")) {
        for (int i = 0;i < sortedArr.length-1;i++) {
          //If any array entry is smaller than the one following it, the array is not sorted
          if (sortedArr[i] < sortedArr[i+1]) {
            System.out.println("------------------------------------------------------");
            System.out.println("WARNING! Array not properly sorted in descending order!");
            System.out.println("------------------------------------------------------");
          }
        }
      }

      return sortedArr;
    }

    public abstract int[] internalSort(int[] unsortedArr, String order);

    public long getLastExecutionTime() {
      return lastSortSpeed;
    }

    public int getLastNumOfComparisons() {
      return lastNumSortComparisons;
    }
}
