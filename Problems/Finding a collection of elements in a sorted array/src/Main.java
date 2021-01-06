import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array1 = new int[n];

        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int[] array2 = new int[k];

        for (int j = 0; j < k; j++) {
            array2[j] = scanner.nextInt();
        }

        for (int i : array2) {
            System.out.print(recursiveBinarySearch(array1, i, 0, array1.length - 1) + " ");
        }
    }

    public static int recursiveBinarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == value) {
            return mid + 1;
        } else if (array[mid] < value) {
            return recursiveBinarySearch(array, value, mid + 1, right); //go to right subArray
        } else {
            return recursiveBinarySearch(array, value, left, mid - 1); //go to left subArray
        }
    }
}