import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findSecondLargestNumber(int[] numbers) {

        if (numbers.length < 2) {
            return Integer.MIN_VALUE;
        }

        int firstMax = Math.max(numbers[0], numbers[1]);
        int secondMax = Math.min(numbers[0], numbers[1]);


        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > firstMax) {
                secondMax = firstMax;
                firstMax = numbers[i];
            } else if (numbers[i] > secondMax & numbers[i] != firstMax) {
                secondMax = numbers[i];
            } else if (secondMax == firstMax && numbers[i] < secondMax) {
                secondMax = numbers[i];
            }
        }

        if (firstMax == secondMax) {
            return Integer.MIN_VALUE;
        }

        return secondMax;
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
        System.out.println(findSecondLargestNumber(numbers));
    }
}