import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        System.out.println(editDistance(word1, word2));
    }

    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static int editDistance(String s, String t) {
        int[][] d = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < t.length() + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = d[i][j - 1] + 1;
                int delCost = d[i - 1][j] + 1;
                //int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                //d[i][j] = Math.min((insCost + delCost), subCost);
                //d[i][j] = subCost;
                if (match(s.charAt(i - 1), t.charAt(j - 1)) == 0) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.min(insCost, delCost);
                }
            }
        }

        return d[s.length()][t.length()];
    }
}