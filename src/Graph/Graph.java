package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    int n;
    ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    Graph(int n) {
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

    }

    public void addEdge(Integer u, Integer v, boolean bidir) {
        adjacencyList.get(u).add(v);
        if(bidir) {
            adjacencyList.get(v).add(u);
        }

    }

    public void display() {
        for(int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + " -> " + adjacencyList.get(i).toString());
        }
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 4)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(3, 4)));

        Graph g = new Graph(5);

        edges.forEach(edge -> {
            g.addEdge(edge.get(0), edge.get(1), true);
        });

        for (ArrayList<Integer> list : g.adjacencyList) {
            Collections.sort(list);
        }

        g.display();
    }

}
