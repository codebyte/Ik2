package Graph;


import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.util.*;

public class Graph1 {

    public static ArrayList<ArrayList<Integer>> createAdjacencyList(int n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            adjacencyList.get(edge.get(0)).add(edge.get(1));
            adjacencyList.get(edge.get(1)).add(edge.get(0));
        }
        return adjacencyList;
    }

    static ArrayList<Integer> bfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(n, edges);

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) bfs(i, adjacencyList, visited, result);
        }
        return result;
    }

    public static void bfs(Integer src, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, ArrayList<Integer> result) {

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();
            result.add(parent);

            if (adjacencyList.get(parent) == null) {
                continue;
            }

            ArrayList<Integer> children = adjacencyList.get(parent);
            children.forEach(child -> {
                if (!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            });
        }
    }


    public static void dfs(Integer u, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> result) {

        Stack<Integer> stack = new Stack<>();
        stack.add(u);
        visited[u] = true;

        while (!stack.isEmpty()) {
            int parent = stack.pop();
            result.add(parent);

            if (adjacencyList.get(parent) == null) {
                continue;
            }
            adjacencyList.get(parent).forEach(v -> {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.add(v);
                }
            });
        }
    }

    public static void dfs1(Integer u, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> result) {
        if (visited[u]) {
            return;
        }

        visited[u] = true;
        result.add(u);
        if (adjacencyList.get(u) != null) {
            adjacencyList.get(u).forEach(v -> {
                dfs1(v, visited, adjacencyList, result);
            });
        }
    }


    static ArrayList<Integer> dfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(n, edges);
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //dfs(i, visited, adjacencyList, result);
                dfs1(i, visited, adjacencyList, result);
            }
        }
        return result;
    }

    public static void bfs2(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> result) {

        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        while (!q.isEmpty()) {
            u = q.poll();
            result.add(u);

            if (adjacencyList.get(u) == null) {
                continue;
            }
            adjacencyList.get(u).forEach(v -> {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            });

        }
    }

    public static void dfs2(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> result) {
        if (visited[u]) {
            return;
        }
        if (adjacencyList.get(u) == null) {
            return;
        }
        visited[u] = true;
        adjacencyList.get(u).forEach(v -> {
            dfs2(v, visited, adjacencyList, result);
        });
    }

    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();
        int numConnectedComponents = 0;

        adjacencyList = createAdjacencyList(n, edges);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) numConnectedComponents++;
            //dfs2(i, visited, adjacencyList, result);
            bfs2(i, visited, adjacencyList, result);
        }
        return numConnectedComponents;
    }

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<>(List.of(0, 1)));
        edges1.add(new ArrayList<>(List.of(1, 2)));
        edges1.add(new ArrayList<>(List.of(0, 2)));
        edges1.add(new ArrayList<>(List.of(3, 4)));
        System.out.println(number_of_connected_components(5, edges1));


        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>();
        edges2.add(new ArrayList<>(List.of(0, 1)));
        edges2.add(new ArrayList<>(List.of(0, 3)));
        edges2.add(new ArrayList<>(List.of(0, 2)));
        edges2.add(new ArrayList<>(List.of(2, 1)));
        edges2.add(new ArrayList<>(List.of(2, 3)));
        System.out.println(number_of_connected_components(4, edges2));
    }

}
