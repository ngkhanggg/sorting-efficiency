public abstract class Sorter {

    long lastSortSpeed;
    int lastNumSortComparisons;

    public abstract int[] sort(int[] unsortedArr, String order);

    public long getLastExecutionTime() {
      return lastSortSpeed;
    }

    public int getLastNumOfComparisons() {
      return lastNumSortComparisons;
    }
}
