import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        if (word1.length() < word2.length()) {
            System.out.println(editDistance(word1, word2));
        } else {
            System.out.println(editDistance(word2, word1));
        }

    }

    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static int editDistance(String s, String t) {
        int[][] d = new int[2][s.length() + 1];

        d[0][0] = 0;
        d[1][0] = 1;


        for (int j = 0; j < s.length() + 1; j++) {
            d[0][j] = j;
        }

        int i = 1;

        while (i <= t.length()) {
            for (int j = 1; j < s.length() + 1; j++) {
                int insCost = d[1][j - 1] + 1;
                int delCost = d[0][j] + 1;
                int subCost = d[0][j - 1] + match(t.charAt(i - 1), s.charAt(j - 1));
                d[1][j] = Math.min(Math.min(insCost, delCost), subCost);
            }

            System.arraycopy(d[1], 0, d[0], 0, s.length() + 1);
            d[1][0] = d[1][0] + 1;
            i++;
        }

        return d[0][s.length()];
    }
}