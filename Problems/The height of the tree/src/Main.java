import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int nodeKey = scanner.nextInt();
        Node root = new Node(nodeKey, nodeKey, null);
        Node.nodes.add(root);

        Node.setRoot(root);

        for (int i = 0; i < n - 1; i++) {
            nodeKey = scanner.nextInt();
            Node node = Node.insert(nodeKey, nodeKey);
        }

        int maxHeight = 0;
        for (Node node : Node.nodes) {
            if (node.getHeight() > maxHeight) {
                maxHeight = node.getHeight();
            }
        }

        System.out.println(maxHeight);

    }

}

class Node {
    static Node root;
    static List<Node> nodes = new ArrayList<>();
    int key;
    int value;
    Node left;
    Node right;
    Node parent;
    static int tempHeight = 0;
    private int height = 0;

    public Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    private static Node insert(Node t, Node p, int key, int value) {

        if (t == null) {
            t = new Node(key, value, p);
            t.setHeight(tempHeight);
            nodes.add(t);
            tempHeight = 0;
        } else {
            if (key < t.key) {
                tempHeight++;
                t.left = insert(t.left, t, key, value);
            } else {
                tempHeight++;
                t.right = insert(t.right, t, key, value);
            }
        }

        return t;
    }

    public static Node insert(int key, int value) {
        return insert(root, null, key, value);
    }

    public static void setRoot(Node root) {
        Node.root = root;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}