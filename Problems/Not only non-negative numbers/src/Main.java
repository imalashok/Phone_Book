import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void countingSort(int[] numbers) {
        int max = 30;
        int k = max + 1;
        int[] counts = new int[k];

        for (int i = 0; i < numbers.length; i++) {
            counts[numbers[i] + 10]++;
        }

        int pos = 0;

        for (int num = 0; num < k; num++) {
            int count = counts[num];

            while (count > 0) {
                numbers[pos] = num - 10;
                pos++;
                count--;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String elements = scanner.nextLine();
        final int[] array = Arrays.stream(elements.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        countingSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}