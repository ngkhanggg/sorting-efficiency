public abstract class Sorter {
	public abstract int[] sort(int[] arr);

	public String getExecuteTime(int[] sortedArr, long start, long end) {
		long executingTime = end - start;
		String s = String.format("It takes %s milliseconds to sort %s numbers", executingTime, sortedArr.length);
		
		return s;
	}

	public String getComparisons(int[] sortedArr, int loops) {
		String s = String.format("It takes %s comparisons to sort %s numbers", loops, sortedArr.length);

		return s;
	}
}