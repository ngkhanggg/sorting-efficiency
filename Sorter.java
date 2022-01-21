public abstract class Sorter {

    // Store how fast the last sort() function called was
    long lastSortSpeed;

    // Store how many time a sort() compared to entries of the array
    int lastNumSortComparisons;

    public abstract int[] sort(int[] unsortedArr, String order);

    public long getLastExecutionTime() {
      return lastSortSpeed;
    }

    public int getLastNumOfComparisons() {
      return lastNumSortComparisons;
    }
}
