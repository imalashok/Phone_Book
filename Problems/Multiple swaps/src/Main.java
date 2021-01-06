import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> first = Arrays.asList(scanner.nextLine().split(" "));
        int swaps = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < swaps; i++) {
            Collections.swap(first, scanner.nextInt(), scanner.nextInt());
        }

        for (String s : first) {
            System.out.print(s + " ");
        }
    }
}