package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem
  Feedback
Check If Eulerian Cycle Exists

Check if there exists any eulerian cycle in a given undirected connected graph. The Euler cycle is a path in the graph that visits every edge exactly once and starts and finishes at the same vertex.

Example One

Graph

{
"n": 5,
"edges": [
[0, 1],
[0, 2],
[1, 3],
[3, 0],
[3, 2],
[4, 3],
[4, 0]
]
}
Output:

1
For example, the graph has an Eulerian Cycle, [2, 0, 1, 3, 0, 4, 3, 2].

Example Two

Graph

{
"n": 6,
"edges": [
[0, 4],
[0, 5],
[1, 2],
[2, 3],
[3, 1],
[4, 3],
]
}
Output:

0
Notes

The graph has n vertices, with each vertex having a distinct value from 0 to n - 1.
Edges are given as a list of lists where each inner list has exactly two elements. Each list [X, Y] represents an undirected edge from X to Y.
The list won't contain any duplicate edges i.e. if [X, Y] is present, then there will be no other occurrence of [X, Y] or [Y, X].
Constraints:

1 <= n <= 103
0 <= value of each vertex <= n - 1
0 <= number of edges <= (n * (n - 1)) / 2
The graph won't contain self loops.
 */

public class EulerianCycle {


    static Boolean check_if_eulerian_cycle_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {

        int[] vertices = new int[n];
        Boolean isCycle = true;

        if (edges.isEmpty()) {
            return true;
        }

        edges.forEach(edge -> {
            vertices[edge.get(0)] += 1;
            vertices[edge.get(1)] += 1;
        });

        for (Integer vertex : vertices) {
            if ((vertex == 0) || (vertex % 2 != 0)) {
                isCycle = false;
            }

        }

        return isCycle;
    }

    static Boolean check_if_eulerian_path_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {

        int[] vertices = new int[n];
        Boolean isPath = false;
        int oddVertex = 0;
        int evenVertex = 0;

        edges.forEach(edge -> {
            vertices[edge.get(0)] += 1;
            vertices[edge.get(1)] += 1;
        });

        for (Integer vertex : vertices) {
            if ((vertex % 2 == 0)) {
                evenVertex++;
            } else {
                oddVertex++;
            }
        }

        if ((edges.size() == evenVertex) || ((edges.size() - 2) == oddVertex)) {
            isPath = true;
        }

        return isPath;
    }


    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(0, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(3, 0)));
        edges.add(new ArrayList<>(List.of(3, 2)));
        edges.add(new ArrayList<>(List.of(4, 3)));
        edges.add(new ArrayList<>(List.of(4, 0)));


        System.out.println(check_if_eulerian_cycle_exists(5, edges));


        ArrayList<ArrayList<Integer>> edge1 = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 3)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(3, 2)));
        edges.add(new ArrayList<>(List.of(4, 1)));
        edges.add(new ArrayList<>(List.of(4, 2)));
        System.out.println(check_if_eulerian_path_exists(5, edge1));

        ArrayList<ArrayList<Integer>> edge2 = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(2, 0)));
        edges.add(new ArrayList<>(List.of(3, 2)));
        System.out.println(check_if_eulerian_path_exists(4, edge2));


    }

}
