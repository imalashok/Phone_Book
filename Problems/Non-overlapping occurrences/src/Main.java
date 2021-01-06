import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        List<Integer> indexes = containsPattern(text, pattern);

        System.out.println(indexes.size());

        if (!indexes.isEmpty()) {
            for (Integer i : indexes) {
                System.out.print(i + " ");
            }
        }

    }

    public static List<Integer> containsPattern(String text, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        int nextIndex = 0;

        if (text.length() < pattern.length()) {
            return indexes;
        }

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound && (indexes.isEmpty() || nextIndex + pattern.length() - 1 < i)) {
                indexes.add(i);
                nextIndex = i;
            }

            if (pattern.length() == 0) {
                return indexes;
            }
        }

        return indexes;
    }
}