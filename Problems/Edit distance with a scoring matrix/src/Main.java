import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int dictLength = Integer.parseInt(scanner.nextLine());

        String[] dictionary = new String[dictLength];

        for (int i = 0; i < dictLength; i++) {
            dictionary[i] = scanner.nextLine();
        }

        String minWord = "";
        int minDistance = Integer.MAX_VALUE;

        for (String s : dictionary) {
            int distance = editDistance(word, s);
            if (distance < minDistance) {
                minWord = s;
                minDistance = distance;
            }
        }

        System.out.println(minDistance + "\n" + minWord);

    }

    public static int match(char a, char b) {
        List<Integer>[] weights = new List[6];
        weights[0] = Arrays.asList(0, 1, 2, 5, 6, 7);
        weights[1] = Arrays.asList(1, 0, 1, 5, 6, 7);
        weights[2] = Arrays.asList(2, 1, 0, 5, 6, 7);
        weights[3] = Arrays.asList(5, 6, 7, 0, 1, 2);
        weights[4] = Arrays.asList(5, 6, 7, 1, 0, 1);
        weights[5] = Arrays.asList(5, 6, 7, 2, 1, 0);

        Map<Character, Integer> dictMap = new HashMap<>();
        dictMap.put('a', 0);
        dictMap.put('s', 1);
        dictMap.put('d', 2);
        dictMap.put('b', 3);
        dictMap.put('n', 4);
        dictMap.put('m', 5);

        return weights[dictMap.getOrDefault(a, 0)].get(dictMap.getOrDefault(b, 0));
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
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }

        return d[s.length()][t.length()];
    }
}