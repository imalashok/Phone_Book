import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(insertionSort(array));
    }

    public static int insertionSort(int[] array) {
        int numberOfShifts = 0;
        boolean isShifted = false;

        /* iterating over elements in the unsorted part */
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // take the next element
            int j = i - 1;

            /* find a suitable position to insert and shift elements to the right */
            while (j >= 0 && array[j] < elem) {
                array[j + 1] = array[j]; // shifting
                j--;
                isShifted = true;
            }
            array[j + 1] = elem; // insert the element in the found position in the sorted part

            if (isShifted) {
                numberOfShifts++;
                isShifted = false;
            }
        }

        return numberOfShifts;
    }
}