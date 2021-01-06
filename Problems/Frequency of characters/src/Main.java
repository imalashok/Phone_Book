import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> first = Arrays.asList(scanner.nextLine().split(" "));
        String s = scanner.nextLine();

        System.out.println(Collections.frequency(first, s));

    }
}