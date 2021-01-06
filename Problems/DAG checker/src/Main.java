import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = Integer.parseInt(scanner.nextLine().trim());

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            String edge = scanner.nextLine();
            String[] edgeNodes = edge.split(" ");

            graph.addEdge(Integer.parseInt(edgeNodes[0]), Integer.parseInt(edgeNodes[1]));
        }

        graph.topologicalSort();

        if (graph.isCyclic()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

class Graph {
    private int n;
    private List<Integer>[] adjList;
    private List<Integer> topSort;
    private boolean[] used;
    private List<Integer> nodesBeingVisited = new ArrayList<>();
    private boolean cyclic = false;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList[n + 1];
        topSort = new ArrayList<>();
        used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList();
        }
    }

    public void addEdge(int a, int b) {
        adjList[a].add(b);
    }

    private void dfs(int v) {

        used[v] = true;
        nodesBeingVisited.add(v);
        for (Integer to : adjList[v]) {
            if (nodesBeingVisited.contains(to)) {
                cyclic = true;
                break;
            }
            if (!used[to]) {
                dfs(to);
            }
        }
        nodesBeingVisited.clear();
        topSort.add(v);
    }

    public List<Integer> topologicalSort() {
        for (int i = 1; i <= n; i++) {
            used[i] = false;
        }
        topSort.clear();
        for (int i = 1; i <= n; i++) {
            nodesBeingVisited.clear();
            if (!used[i]) {
                dfs(i);
            }
        }
        Collections.reverse(topSort);
        return topSort;
    }

    public boolean isCyclic() {
        return cyclic;
    }
}