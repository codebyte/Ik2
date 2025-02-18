package leetcode;

import java.util.*;

public class CourseSchedule {


    static int time = 0;

    public static boolean dfs(int u, boolean[] visited, Map<Integer, ArrayList<Integer>> adjacencyList, int[] departure) {
        visited[u] = true;

        if (adjacencyList.containsKey(u)) {
            for (Integer v : adjacencyList.get(u)) {
                if (!visited[v]) {
                    if (!dfs(v, visited, adjacencyList, departure)) {
                        return false;
                    }
                } else {
                    if (departure[v] == 0) {
                        return false;
                    }
                }
            }
        }
        departure[u] = ++time;
        return true;
    }

    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            adjacencyList.putIfAbsent(a, new ArrayList<>());
            adjacencyList.get(a).add(b);
        }

        int[] departure = new int[numCourses];
        boolean[] visited = new boolean[numCourses];


        for (int u = 0; u < numCourses; u++) {
            if (!visited[u]) {
                if (!dfs(u, visited, adjacencyList, departure)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
        int inDegree[] = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            inDegree[b]++;
            adjacencyList.putIfAbsent(a, new ArrayList<>());
            adjacencyList.get(a).add(b);
        }

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.putIfAbsent(i, new ArrayList<>());
        }


        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> courses = new ArrayList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            courses.add(node);

            for (int v : adjacencyList.get(node)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if (courses.size() < numCourses) {
            return new int[0]; // Cycle detected
        }

        int a[] = new int[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            a[i] = courses.get(i);
        }
        return a;
    }

    public static void main(String args[]) {

        int numCourses = 2;
        int prerequisites[][] = {{1, 0}, {1, 2}, {0, 1}};

        System.out.println(Arrays.toString(canFinish(numCourses, prerequisites)));

    }
}
