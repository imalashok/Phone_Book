import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();
        String command = scanner.next();

        while (!"+".equals(command)) {
            command = scanner.next();
        }

        int nodeKey = scanner.nextInt();
        int nodeValue = Integer.parseInt(scanner.nextLine().trim());

        Node node = new Node(nodeKey, nodeValue, null);
        Node.nodes.add(node);

        Node.setRoot(node);

        while (scanner.hasNextLine()) {
            command = scanner.next();

            switch (command) {
                case "+":
                    nodeKey = scanner.nextInt();
                    nodeValue = Integer.parseInt(scanner.nextLine().trim());
                    node = Node.insert(nodeKey, nodeValue);
                    break;
                case "-":
                    nodeKey = Integer.parseInt(scanner.nextLine().trim());
                    Node.remove(nodeKey);
                    break;
                case "!":
                    nodeKey = scanner.nextInt();
                    nodeValue = Integer.parseInt(scanner.nextLine().trim());
                    node = Node.search(nodeKey);

                    if (node != null) {
                        node.setValue(nodeValue);
                    }
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }

        Map<Integer, Integer> nod = new TreeMap<>();
        for (Node currentNode : Node.nodes) {
            nod.put(currentNode.getKey(), currentNode.getValue());
        }

        for (Integer value : nod.values()) {
            System.out.print(value + " ");
        }
    }

}

class Node {
    static List<Node> nodes = new ArrayList<>();
    static int tempHeight = 0;
    private static Node root;
    int key;
    int value;
    Node left;
    Node right;
    Node parent;
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

    static Node search(Node t, int key) {
        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.left, key);
        else
            return search(t.right, key);
    }

    public static Node search(int key) {
        return search(root, key);
    }

    static void replace(Node a, Node b) {
        if (a.parent == null) {
            root = b;
        } else if (a == a.parent.left) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }
        if (b != null) {
            b.parent = a.parent;
        }
        if (b != null) {
            b.setHeight(a.height);
        }
        nodes.remove(a);
    }

    static void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.left, key);
        else if (key > t.key)
            remove(t.right, key);
        else if (t.left != null && t.right != null) {
            Node m = t.right;
            while (m.left != null)
                m = m.left;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    public static void remove(int key) {
        remove(root, key);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}