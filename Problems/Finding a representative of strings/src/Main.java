import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        int[] hammingDistances = new int[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        int k = 0;

        for (int j = 0; j < n; j++) {
            k++;

            int p = k;
            while (p < n) {

                if (j == p) {
                    continue;
                }

                for (int m = 0; m < words[0].length(); m++) {
                    if (words[j].charAt(m) != words[p].charAt(m)) {
                        hammingDistances[j]++;
                        hammingDistances[p]++;
                    }
                }
                p++;
            }
        }

        int minHammingDistance = hammingDistances[0];
        int indexOfMinHammingDistance = 0;
        for (int r = 1; r < n; r++) {
            if (hammingDistances[r] < minHammingDistance) {
                minHammingDistance = hammingDistances[r];
                indexOfMinHammingDistance = r;
            }
        }

        System.out.println(words[indexOfMinHammingDistance]);
    }
}