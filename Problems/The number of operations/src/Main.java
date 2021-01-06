import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] operations = new int[n];

        for (int i = 0; i < n; i++) {
            int[] array = new int[m];
            for (int j = 0; j < m; j++) {
                array[j] = scanner.nextInt();
            }
            operations[i] = selectionSort(array);
        }

        int max = 0;

        for (int i = 1; i < n; i++) {
            if (operations[i] > operations[max]) {
                max = i;
            }
        }

        System.out.print(max + 1);

    }

    public static int selectionSort(int[] array) {
        if (array.length == 0) {
                return -1;
        }

        int operations = 0;

        for (int i = 0; i < array.length; i++) {
            int index = i; // the index of the found min

        /* Iterating over the unsorted subarray to find the min */
        for (int j = i; j < array.length; j++) {
            if (array[j] < array[index]) {
                index = j;
                operations++;
            }
        }

        /* Exchanging the found min and the current element */
        int min = array[index];
        array[index] = array[i];
        array[i] = min;
        operations++;
    }

        return operations;
    }
}