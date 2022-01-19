import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] unsortedArr = generateUnsortedArr(10);

        for (int num: unsortedArr) {
            System.out.print(num + " ");
        }

        int[] sortedArr = sort("selection", unsortedArr);

        System.out.println();

        for (int num: sortedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] generateUnsortedArr(int size) {
        Random rd = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(99) + 1;
        }

        return arr;
    }

    public static int[] sort(String typeOfSorter, int[] arr) {
        switch(typeOfSorter) {
            case "selection":
                return selectionSort(arr);
            default:
                return arr;
        }
    }

    public static int[] selectionSort(int[] arr) {
        int[] newArr = arr.clone();

        for (int i = 0; i < newArr.length - 1; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                if (newArr[i] > newArr[j]) {
                    int temp = newArr[i];
                    newArr[i] = newArr[j];
                    newArr[j] = temp;
                }
            }
        }

        return newArr;
    }
}
