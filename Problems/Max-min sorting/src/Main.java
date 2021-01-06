import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        array = selectionSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] selectionSort(int[] array) {
        boolean isSearchingForMax = true;

        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (isSearchingForMax) {
                    if (array[j] > array[index]) {
                        index = j;
                    }
                } else {
                    if (array[j] < array[index]) {
                        index = j;
                    }
                }
            }

            /* Exchanging the found min and the current element */
            int found = array[index];
            array[index] = array[i];
            array[i] = found;

            isSearchingForMax = !isSearchingForMax;
        }

        return array;
    }
}