// Helper class. Contains sorter sublclass instances and all the sorting related methods needed by the GUI

public class SorterHelper {

    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    QuickSort quick = new QuickSort();
    MergeSort merge = new MergeSort();

    // choose between sorting methods
    public int[] sort(int[] arr, String sorter, String order) {
        switch(sorter) {
            case "Bubble Sort":
                selection.sort(arr, order);
                quick.sort(arr, order);
                merge.sort(arr, order);
                return bubble.sort(arr, order);
            case "Selection Sort":
                bubble.sort(arr, order);
                quick.sort(arr, order);
                merge.sort(arr, order);
                return selection.sort(arr, order);
            case "Quick Sort":
                bubble.sort(arr, order);
                selection.sort(arr, order);
                merge.sort(arr, order);
                return quick.sort(arr, order);
            case "Merge Sort":
                bubble.sort(arr, order);
                selection.sort(arr, order);
                quick.sort(arr, order);
                return merge.sort(arr, order);
            default:
                return arr;
        }
    }

    public String getExecutionDetails(String sorter) {
        switch(sorter) {
            case "Bubble Sort":
                return bubble.stringForGUI();
            case "Selection Sort":
                return selection.stringForGUI();
            case "Quick Sort":
                return quick.stringForGUI();
            case "Merge Sort":
                return merge.stringForGUI();
            default:
                return "";
        }
    }
}