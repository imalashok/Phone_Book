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

        int[] lengthArray = new int[number];

        for (int i = 0; i < number; i++) {
            lengthArray[i] = -1;
        }

        for (int i = 0; i < number; i++) {

            int num = array[i];
            int length = 1;

            while (num != -1) {
                if (lengthArray[num] != -1) {
                    length += lengthArray[num];
                    break;
                }
                length++;
                num = array[num];
            }

            lengthArray[i] = length;
            maxLength = Math.max(length, maxLength);
        }

        System.out.println(maxLength);
    }
}