import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[] chars = new char[n];

        for (int i = 0; i < n; i++) {
            chars[i] = scanner.next().charAt(0);
        }

        countingSort(chars);

        for (char c : chars) {
            System.out.print(c + " ");
        }
    }


    public static void countingSort(char[] chars) {
        int max = 9;
        int k = max + 1;
        int[] counts = new int[k];

        for (char aChar : chars) {
            counts[aChar - 97]++;
        }

        int pos = 0;

        for (int num = 0; num < k; num++) {
            int count = counts[num];

            while (count > 0) {
                chars[pos] = (char) (num + 97);
                pos++;
                count--;
            }
        }
    }
}