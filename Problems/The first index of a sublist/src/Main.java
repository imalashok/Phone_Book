import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> first = new ArrayList<>(List.of((scanner.nextLine().split(" "))));
        List<String> second = new ArrayList<>(List.of((scanner.nextLine().split(" "))));

        System.out.println(Collections.indexOfSubList(first, second) + " " + Collections.lastIndexOfSubList(first, second));
    }
}