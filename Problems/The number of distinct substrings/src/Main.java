import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Set<Long> uniquePrefixes = new HashSet<>();

        for (int i = 0; i < text.length() + 1; i++) {
            String substring = text.substring(0, i);
//            System.out.println(substring);
            uniquePrefixes.addAll(RabinKarp(text, substring));
        }

        System.out.println(uniquePrefixes.size());
    }

    /* 1 */
    public static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    public static Set<Long> RabinKarp(String text, String pattern) {
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
        Set<Long> occurrences = new HashSet<>();

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash != currSubstrHash || text.length() == pattern.length()) {
                occurrences.add(currSubstrHash);
                }


            if (i > pattern.length()) {
                /* 5 */
                currSubstrHash = (currSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
            }
        }

        return occurrences;
    }
}