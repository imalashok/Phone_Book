import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.next());
        }

        int k = scanner.nextInt();

        array = selectionSort(array, k);

        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static int[] selectionSort(int[] array, int k) {
        for (int i = 0; i < array.length - 1; i++, k--) {
            if (k == 0) {
                break;
            }
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }

            /* Exchanging the found min and the current element */
            int max = array[index];
            array[index] = array[i];
            array[i] = max;
        }

        return array;
    }
}