import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(binarySearch(array, 0, array.length - 1));
    }


    public static boolean binarySearch(int[] array, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == mid) {
                return true;
            } else if (array[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}