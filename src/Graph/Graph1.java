package Graph;


import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph1 {

    int n;
    ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    Graph1(int n) {
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
    }

    public void addEdge(Integer u, Integer v, boolean bdir) {
        adjacencyList.get(u).add(v);
        if (bdir) {
            adjacencyList.get(v).add(u);
        }
    }

    public void display() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + " -> " + adjacencyList.get(i).toString());
        }
    }

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


    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(0, 2)));
        edges.add(new ArrayList<>(List.of(0, 4)));
        edges.add(new ArrayList<>(List.of(2, 3)));

        System.out.println(bfs_traversal(6, edges));
    }

}
