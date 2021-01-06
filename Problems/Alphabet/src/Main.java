import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordsMapping = new HashMap<>();
        List<String> edges = new ArrayList<>();
        List<Integer> sortedList;

        int m = Integer.parseInt(scanner.nextLine().trim());

        String word = scanner.nextLine();

        for (int i = 0; i < m - 1; i++) {
            String nextWord = scanner.nextLine();

            for (int j = 0; j < Math.min(word.length(), nextWord.length()); j++) {
                wordsMapping.putIfAbsent("" + word.charAt(j), wordsMapping.size() + 1);
                wordsMapping.putIfAbsent("" + nextWord.charAt(j), wordsMapping.size() + 1);

                if (word.charAt(j) != nextWord.charAt(j)) {

                    String newEdge = word.charAt(j) + " " + nextWord.charAt(j);

                    if (!edges.contains(newEdge)) {
                        edges.add(newEdge);
                    }

                    break;
                }
            }

            word = nextWord;
        }

        int n = wordsMapping.size();
        Graph graph = new Graph(n);


        for (String s : edges) {
            String[] edgeNodes = s.split(" ");

            graph.addEdge(wordsMapping.get(edgeNodes[0]), wordsMapping.get(edgeNodes[1]));

        }

        sortedList = graph.topologicalSort();
        //System.out.println(sortedList);

        for (Integer number : sortedList) {
            for (var wm : wordsMapping.entrySet()) {
                if (wm.getValue() == number) {
                    System.out.print(wm.getKey());
                }
            }
        }
    }
}

class Graph {
    private int n;
    private List<Integer>[] adjList;
    private List<Integer> topSort;
    private boolean[] used;
    private List<Integer> nodesBeingVisited = new ArrayList<>();

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
}