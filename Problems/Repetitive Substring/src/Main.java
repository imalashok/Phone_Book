import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        boolean flag = false;

        for (int i = 0; i <= text.length() - k; i++) {
            String substring = text.substring(text.length() - k - i, text.length() - i);
            //System.out.println(substring);

            if (text.length() - i - 1 >= substring.length()) {
                flag = RabinKarp(text.substring(0, text.length() - i - 1), substring);

                if (flag) {
                    System.out.println(substring);
                    break;
                }
            }
        }

        if (!flag) {
            System.out.println("does not contain");
        }
    }

    /* 1 */
    public static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    public static boolean RabinKarp(String text, String pattern) {
        /* 2 */
        int a = 53;
        long m = 1_000_000_000 + 9;

        /* 3 */
        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;

            currSubstrHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currSubstrHash %= m;

            if (i != pattern.length() - 1) {
                pow = pow * a % m;
            }
        }

        /* 4 */

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash == currSubstrHash) {
                boolean patternIsFound = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
                        patternIsFound = false;
                        break;
                    }
                }

                if (patternIsFound) {
                    return true;
                }
            }

            if (i > pattern.length()) {
                /* 5 */
                currSubstrHash = (currSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
            }
        }

        return false;
    }
}