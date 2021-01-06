import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        int startIndex = 0;
        int minHammingDistance = Integer.MAX_VALUE;

        for (int i = 0; i <= text.length() - k; i++) {
            int min = 0;

            for (int j = 0; j < k; j++) {
                if (pattern.charAt(k - 1 - j + i) != text.charAt(j + i)) {
                    min++;
                }
            }

            if (min < minHammingDistance) {
                minHammingDistance = min;
                startIndex = i;
            }
        }

        System.out.print(startIndex + " " + minHammingDistance);
    }
}