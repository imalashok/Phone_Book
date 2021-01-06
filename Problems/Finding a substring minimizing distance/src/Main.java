import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        int startIndex = 0;
        int minHammingDistance = Integer.MAX_VALUE;

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int min = 0;
            int k = 0;

            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(k + j) != text.charAt(i + j)) {
                    min++;
                }
            }

            if (min < minHammingDistance) {
                minHammingDistance = min;
                startIndex = i;
            }
        }

        System.out.println(startIndex + " " + minHammingDistance);
    }
}