import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        scanner.nextLine();
        List<String> first = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            first.add(scanner.nextLine());
        }

        int rotateCount = scanner.nextInt();

        Collections.rotate(first, rotateCount);

        for (String s : first) {
            System.out.println(s);
        }
    }
}