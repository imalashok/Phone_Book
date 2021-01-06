import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> edges = new HashMap<>();

        boolean flag = true;


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] node = scanner.nextLine().split(" ");

            edges.put(Integer.parseInt(node[0]), edges.getOrDefault(Integer.parseInt(node[0]), 0) + 1);
        }

        for (Integer value : edges.values()) {
            if (value != 2) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "yes" : "no");
    }
}