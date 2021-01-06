import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        int maxLength = 0;

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < number; i++) {
            int num = array[i];
            int length = 0;

            while (num > -1) {
                length++;
                num = array[num];
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }
        System.out.println(maxLength + 1);
    }
}