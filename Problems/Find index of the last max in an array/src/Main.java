import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findIndexOfLastMax(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }

        int maxIndex = 0;
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] >= max) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } else {
            numbers = new int[0];
        }
        System.out.println(findIndexOfLastMax(numbers));
    }
}