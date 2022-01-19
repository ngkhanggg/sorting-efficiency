import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArr = generateArr(99);

        for (int num: unsortedArr) {
            System.out.print(num + " ");
        }

        int[] sortedArr = useSort("selection", unsortedArr);

        System.out.println();

        for (int num: sortedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] generateArr(int length) {
        Random rd = new Random();

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(99) + 1;
        }

        return arr;
    }

    public static int[] useSort(String type, int[] arr) {
        switch(type) {
            case "selection":
                SelectionSort sort = new SelectionSort();
                return sort.sort(arr);
            default:
                return arr;
        }
    }
}
