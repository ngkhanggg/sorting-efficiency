public abstract class Sorter {
    protected long executionTime;
    protected int comparisons;

    public abstract String getName();

    public abstract int[] sort(int[] unsortedArr, String order);

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
