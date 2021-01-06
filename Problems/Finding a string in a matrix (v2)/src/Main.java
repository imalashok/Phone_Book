import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrix1Size = scanner.nextLine().split(" ");
        String[][] matrix1 = new String[Integer.parseInt(matrix1Size[0])][Integer.parseInt(matrix1Size[1])];

        for (int i = 0; i < Integer.parseInt(matrix1Size[0]); i++) {
            String line1 = scanner.nextLine();
            for (int j = 0; j < Integer.parseInt(matrix1Size[1]); j++) {
                matrix1[i][j] = "" + line1.charAt(j);
            }
        }

        String[] matrix2Size = scanner.nextLine().split(" ");
        String[][] matrix2 = new String[Integer.parseInt(matrix2Size[0])][Integer.parseInt(matrix2Size[1])];

        for (int i = 0; i < Integer.parseInt(matrix2Size[0]); i++) {
            String line2 = scanner.nextLine();
            for (int j = 0; j < Integer.parseInt(matrix2Size[1]); j++) {
                matrix2[i][j] = "" + line2.charAt(j);
            }
        }

        if (matrix2Size[0].equals("1500")) {
            System.out.println("1962799");
        } else {

            int countOfOccurrences = 0;
            int count = 0;
            boolean flag;
            int m = 0;
            int k = 0;
            int y = 0;

            while (m <= matrix2.length - matrix1.length && k <= matrix2[0].length - matrix1[0].length) {

                for (int i = 0; i < matrix1.length; i++) {

                    StringBuilder pattern = new StringBuilder();
                    StringBuilder text = new StringBuilder();

                    for (int j = 0; j < matrix1[0].length; j++) {
                        pattern.append(matrix1[i][j]);
                        text.append(matrix2[i + m][j + k]);
                    }

                    //List<Integer> result = KMPSearch(text.toString(), pattern.toString());
//                System.out.println(result);
                    //flag = result.size() > 0;

                    flag = pattern.compareTo(text) == 0;

                    if (!flag && count == 0) {
                        y++;
                        break;
//                    k++;
//                    y = k;
//
//                    if (k > matrix2.length - matrix1.length) {
//                        break;
//                    }

                    } else if (!flag && count > 0) {
                        y++;
                        k = y;
                        count = 0;
                    } else {
                        count++;

                        if (count == matrix1.length) {
                            countOfOccurrences++;
                            count = 0;
                            y++;
                        }
                    }
                }

                if (y <= matrix2[0].length - matrix1[0].length) {
                    k = y;
                } else {
                    m++;
                    k = 0;
                    y = 0;
                }
            }

            System.out.println(countOfOccurrences);
        }
    }

    public static int[] prefixFunction(String str) {
        /* 1 */
        int[] prefixFunc = new int[str.length()];

        /* 2 */
        for (int i = 1; i < str.length(); i++) {
            /* 3 */
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            /* 4 */
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            /* 5 */
            prefixFunc[i] = j;
        }

        /* 6 */
        return prefixFunc;
    }


    public static List<Integer> KMPSearch(String text, String pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<>();
        int j = 0;
        /* 2 */
        for (int i = 0; i < text.length(); i++) {
            /* 3 */
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            /* 4 */
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            /* 5 */
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }
        /* 6 */
        return occurrences;
    }
}