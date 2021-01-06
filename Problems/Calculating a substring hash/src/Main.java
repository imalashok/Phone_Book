import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = 53;
        long m = 1_000_000_000 + 9;

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<Long> allPrefixHashes = calculateHashForAllPrefixes(text, a, m);
        List<Long> calculatedPrefixHashes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int k = 0; k < n; k++) {
            String[] borders = scanner.nextLine().split(" ");
            int i = Integer.parseInt(borders[0]);
            int j = Integer.parseInt(borders[1]);

            calculatedPrefixHashes.add(calculateHashOfTwoBorders(allPrefixHashes, i, j, m));
        }

        for (int i = 1; i < allPrefixHashes.size(); i++) {
            System.out.print(allPrefixHashes.get(i));

            if (i != allPrefixHashes.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        for (int j = 0; j < calculatedPrefixHashes.size(); j++) {
            System.out.print(calculatedPrefixHashes.get(j));

            if (j != calculatedPrefixHashes.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static Long calculateHashOfTwoBorders(List<Long> allPrefixHashes, int i, int j, long m) {
        long calculatedPrefix = allPrefixHashes.get(j) - allPrefixHashes.get(i);

        return calculatedPrefix > 0 ? calculatedPrefix : calculatedPrefix + m;
    }

    public static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    public static List<Long> calculateHashForAllPrefixes(String text, int a, long m) {
        ArrayList<Long> hashes = new ArrayList<>();
        hashes.add(0L);

        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < text.length(); i++) {
            currSubstrHash += charToLong(text.charAt(i)) * pow;
            currSubstrHash %= m;

            if (i != text.length() - 1) {
                pow = pow * a % m;
            }

            hashes.add(currSubstrHash);
        }

        return hashes;
    }

}