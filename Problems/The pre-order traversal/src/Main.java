import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int depth = scanner.nextInt();

        printNode(0, 0, depth);
    }


    public static void printNode(int currentNode, int currentDepth, int depth) {
        if (currentDepth > depth) {
            return;
        }

        System.out.print(currentNode + " ");

        for (int i = 1; i <= 3; i++) {
            printNode(currentNode * 3 + i, currentDepth + 1, depth);
        }
    }
}