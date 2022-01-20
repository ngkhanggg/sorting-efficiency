public abstract class Sorter {
    public abstract int[] sort(int[] unsortedArr, String order);

    public void printExecutionTime(int sizeOfArr, long duration) {
        System.out.printf("It takes %s milliseconds to sort %s numbers", duration, sizeOfArr);
    }

    public void printNumOfComparisons(int sizeOfArr, int comparisons) {
        System.out.printf("It takes %s comparisons to sort %s numbers", comparisons, sizeOfArr);
    }
}
