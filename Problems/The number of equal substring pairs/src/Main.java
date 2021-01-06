import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<Long> calculatedPows = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int a = 53;
        long m = 1_000_000_000 + 9;

        BufferedReader scanner =
                new BufferedReader(new InputStreamReader(System.in));

        String text = scanner.readLine();
        int t = Integer.parseInt(scanner.readLine());

        List<Long> allPrefixHashes = calculateHashForAllPrefixes(text, a, m);

        int count = 0;

        for (int k = 0; k < t; k++) {
            String[] borders = scanner.readLine().split(" ");
            int i1 = Integer.parseInt(borders[0]);
            int j1 = Integer.parseInt(borders[1]);
            int i2 = Integer.parseInt(borders[2]);
            int j2 = Integer.parseInt(borders[3]);

            long hashOfFirstSubstring;
            long hashOfSecondSubstring;

            if (i1 <= i2) {
                hashOfFirstSubstring = calculateHashOfTwoBorders(allPrefixHashes, i1, j1, m) * calculatedPows.get(i2 - i1) % m;
                hashOfSecondSubstring = calculateHashOfTwoBorders(allPrefixHashes, i2, j2, m) % m;
            } else {
                hashOfFirstSubstring = calculateHashOfTwoBorders(allPrefixHashes, i1, j1, m) % m;
                hashOfSecondSubstring = calculateHashOfTwoBorders(allPrefixHashes, i2, j2, m) * calculatedPows.get(i1 - i2) % m;
            }

            //System.out.println(allPrefixHashes);
            //System.out.println(hashOfFirstSubstring);
            //System.out.println(hashOfSecondSubstring);

            if (hashOfFirstSubstring == hashOfSecondSubstring) {
                count++;
            }
        }

        System.out.print(count);
    }

    private static Long calculateHashOfTwoBorders(List<Long> allPrefixHashes, int i, int j, long m) {
        long calculatedPrefix = allPrefixHashes.get(j) - allPrefixHashes.get(i) % m;

        return calculatedPrefix > 0 ? calculatedPrefix : (calculatedPrefix + m);
        //return calculatedPrefix;
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

            calculatedPows.add(pow);

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