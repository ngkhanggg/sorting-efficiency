// Sorter subclass. Sorts using the quick sort algorithm

public class QuickSort extends Sorter {
    public String getName() {
        return "Quick Sort";
    }

    public int[] internalSort(int[] unsortedArr, String order) {
        // clone the unsorted array
        int[] arr = unsortedArr.clone();

        recursiveSort(arr, 0, arr.length-1, order);

        return arr;
    }

    public void recursiveSort(int[] arr, int left, int right, String order) {
        
        //Base case: Left should not be to the right of right. If it is, we've gone too far, so don't run the function. If Left and right are equal, that means its asking for a single entry, and a single entry is sorted already so nothing needs to be done
        if (left >= right) {
            return;
        }

        //The number that will divide the array into higher than and lower than numbers
        int partition = arr[(int)((left+right) / 2)];

        //The counter that will search for out of place numbers on the left of the partition
        int frontCounter = left;

        //The counter that will search for out of place numbers on the right of the partition
        int backCounter = right;
        int temp;

        //If the counters pass each other, we must have looked at the entire array
        while (frontCounter < backCounter) {

            if (order.equals("Ascending")) {
                //Find a number on the left side that is bigger or equal to the partition
                while (arr[frontCounter] < partition) {
                    this.comparisons++;
                    frontCounter++;
                }
                this.comparisons++;

                //Find a number on the right side that is smaller or equal to the partition
                while (arr[backCounter] > partition) {
                    this.comparisons++;
                    backCounter--;
                }
                this.comparisons++;
            }

            else if (order.equals("Descending")) {
                //Find a number on the left side that is smaller or equal to the partition
                while (arr[frontCounter] > partition) {
                    this.comparisons++;
                    frontCounter++;
                }
                this.comparisons++;

                //Find a number on the right side that is bigger or equal to the partition
                while (arr[backCounter] < partition) {
                    this.comparisons++;
                    backCounter--;
                }
                this.comparisons++;
            }

            //Don't do any swapping if the counters have passed each other
            if (frontCounter <= backCounter) {
                temp = arr[frontCounter];
                arr[frontCounter] = arr[backCounter];
                arr[backCounter] = temp;

                //The counters need to move forward so they don't get stuck infinitely swapping two values equal to the partition
                frontCounter++;
                backCounter--;
            }
        }

        //Sort the values left of the partition
        recursiveSort(arr, frontCounter, right, order);

        //Sort the values right of the partition
        recursiveSort(arr, left, backCounter, order);

        return;
    }
}
