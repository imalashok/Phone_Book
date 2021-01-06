import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEdges = Integer.parseInt(scanner.nextLine());

        List<Integer> parents = new ArrayList<>();
        List<Integer> children = new ArrayList<>();

        for (int i = 0; i < numberOfEdges; i++) {
            parents.add(scanner.nextInt());
            children.add(scanner.nextInt());
        }

        List<Integer> leaves = children.stream()
                .filter(x -> !parents.contains(x))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(leaves.size());
        leaves.forEach(x -> System.out.print(x + " "));
    }
}