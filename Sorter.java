// Sorter parent class. Provides the time and comparison count storage and retrival, GUI interaction, and checks to make sure the sort function worked correctly

public abstract class Sorter {

    // These store data for the last sort that the class ran
    protected long executionTime;
    protected int comparisons;

    // Returns the type of sorter the class is
    public abstract String getName();

    // Calls the inherited sort method, and records its execution time
    public int[] sort(int[] unsortedArr, String order) {
      
      // starting time
      long start = System.currentTimeMillis();
      
      int[] sortedArr = internalSort(unsortedArr, order);

      // ending time
      long end = System.currentTimeMillis();

      // Record time elapsed
      this.executionTime = end - start;

      //Check to make sure the array is actually sorted in the right order
      if (order.equals("Ascending")) {
        for (int i = 0;i < sortedArr.length-1;i++) {
          //If any array entry is bigger than the one following it, the array is not sorted
          if (sortedArr[i] > sortedArr[i+1]) {
            System.out.println("------------------------------------------------------");
            System.out.println("WARNING! Array not properly sorted in ascending order!");
            System.out.println("------------------------------------------------------");
            break;
          }
        }
      } else if (order.equals("Descending")) {
        for (int i = 0;i < sortedArr.length-1;i++) {
          //If any array entry is smaller than the one following it, the array is not sorted
          if (sortedArr[i] < sortedArr[i+1]) {
            System.out.println("------------------------------------------------------");
            System.out.println("WARNING! Array not properly sorted in descending order!");
            System.out.println("------------------------------------------------------");
            break;
          }
        }
      }

      return sortedArr;
    }

    public abstract int[] internalSort(int[] unsortedArr, String order);

    public long getExecutionTime() {
        return executionTime;
    }

    public int getComparisons() {
        return comparisons;
    }

    public String stringForGUI() {
        return String.format("<html>%s<br/>- ran in %s milliseconds<br/>- used %s comparisons</html>", getName(), getExecutionTime(), getComparisons());
    }
}
