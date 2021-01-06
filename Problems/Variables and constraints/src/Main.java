import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = Integer.parseInt(scanner.nextLine().trim());

        Graph graph = new Graph(n);

        Map<String, Integer> wordsMapping = new HashMap<>();
        int countOfUniqueWords = 0;

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            wordsMapping.putIfAbsent(word, ++countOfUniqueWords);
        }

        for (int j = 0; j < m; j++) {
            String constraint = scanner.nextLine();
            String[] edges = constraint.split("[<>]");

            if (constraint.contains("<")) {
                graph.addEdge(wordsMapping.get(edges[0]), wordsMapping.get(edges[1]));
            } else if (constraint.contains(">")) {
                graph.addEdge(wordsMapping.get(edges[1]), wordsMapping.get(edges[0]));
            }
        }

        graph.topologicalSort();

        if (graph.isCyclic()) {
            System.out.println("NO");
        } else {
            System.out.println(graph.getNumberOfVariablesWithMinValues());
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

    public int getNumberOfVariablesWithMinValues() {
        List<Integer> minValues = new ArrayList(topSort);

        for (int i = 1; i <= n; i++) {
            for (Integer value : adjList[i]) {
                minValues.remove(value);
            }
        }

        return minValues.size();
    }
}

