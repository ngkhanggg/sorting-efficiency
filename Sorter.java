public abstract class Sorter {
    public abstract int[] sort(int[] unsortedArr);

    public void printExecutionTime(int sizeOfArr, long duration) {
        System.out.printf("It takes %s to sort %s numbers", duration, sizeOfArr);
    }

    public void printNumOfComparisons(int sizeOfArr, int comparisons) {
        System.out.printf("It takes %s to sort %s numbers", comparisons, sizeOfArr);
    }
}
