package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsSourceToTarget {


    public static void dfs(int[][] adjList, int v, ArrayList<Integer> slate, List<List<Integer>> result) {

        slate.add(v);
        System.out.println(slate);
        if (adjList[v].length == 0) {
            result.add(new ArrayList<>(slate));
            slate.remove(slate.size() - 1);
            return;
        }

        for (int i = 0; i < adjList[v].length; i++) {
            int u = adjList[v][i];
            dfs(adjList, u, slate, result);
        }
        slate.remove(slate.size() - 1);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(graph, 0, new ArrayList<>(), result);

        return result;

    }

    public static void main(String args[]) {
        int graph[][] = {
                {1, 2},
                {3},
                {3},
                {}
        };

        System.out.println(allPathsSourceTarget(graph).toString());

    }
}
