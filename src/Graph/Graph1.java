package Graph;


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


    static ArrayList<ArrayList<Integer>> create_adjacencylist(Integer n, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < edge_end.size(); i++) {
            edges.add(i, new ArrayList<>(List.of(edge_start.get(i), edge_end.get(i))));
        }

        adjacencyList = createAdjacencyList(n, edges);

        System.out.println(adjacencyList.toString());

        return adjacencyList;
    }


    static boolean bfs(Integer u, boolean[] visited, int[] parent, ArrayList<ArrayList<Integer>> adjacencyList) {
        Queue<Integer> q = new LinkedList<>();

        visited[u] = true;
        parent[u] = -1;
        q.add(u);
        while (!q.isEmpty()) {
            u = q.poll();

            if (adjacencyList.get(u) == null) {
                continue;
            }

            for (Integer v : adjacencyList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                } else {
                    if (v != parent[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static Boolean is_it_a_tree(Integer
                                        node_count, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {

        boolean[] visited = new boolean[node_count];
        int parent[] = new int[node_count];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int numConnectedComponents = 0;
        boolean result = false;

        adjacencyList = create_adjacencylist(node_count, edge_start, edge_end);

        for (int i = 0; i < node_count; i++) {
            if (!visited[i]) {
                numConnectedComponents++;
                result = bfs(i, visited, parent, adjacencyList);
                if (!result || (numConnectedComponents > 1)) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean bipartite(Integer u, boolean[] visited, Character[] color, ArrayList<ArrayList<Integer>> adjacencyList) {

        for (Integer v : adjacencyList.get(u)) {
            if (!visited[v]) {
                visited[v] = true;
                if (color[u] == 'B') {
                    color[v] = 'W';
                } else {
                    color[v] = 'B';
                }
                if (!bipartite(v, visited, color, adjacencyList)) {
                    return false;
                }
            } else {
                if (color[u] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    // bipartite Graph
    static Boolean can_be_divided(Integer
                                          num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {

        boolean[] visited = new boolean[num_of_people];
        Character[] color = new Character[num_of_people];

        ArrayList<ArrayList<Integer>> adjacencyList = create_adjacencylist(num_of_people, dislike1, dislike2);

        for (int i = 0; i < num_of_people; i++) {
            if (!visited[i]) {
                color[i] = 'B';
                visited[i] = true;
                if (!bipartite(i, visited, color, adjacencyList)) {
                    return false;
                }
            }
        }
        return true;
    }

    static ArrayList<ArrayList<Integer>> getNeighbours(Integer i, Integer j, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();

        if ((matrix.get(i) == null) && (matrix.get(j) == null)) {
            return neighbours;
        }

        if ((i + 1) < matrix.size()) {
            neighbours.add(new ArrayList<>(List.of(i + 1, j)));
        }
        if ((i - 1) >= 0) {
            neighbours.add(new ArrayList<>(List.of(i - 1, j)));
        }

        if ((j + 1) < matrix.get(i).size()) {
            neighbours.add(new ArrayList<>(List.of(i, j + 1)));
        }

        if ((j - 1) >= 0) {
            neighbours.add(new ArrayList<>(List.of(i, j - 1)));
        }

        /*

        if ((i - 1) >= 0) {
            if ((j + 1) < matrix.get(i).size()) {
                neighbours.add(new ArrayList<>(List.of(i - 1, j + 1)));
            }
            if ((j - 1) >= 0) {
                neighbours.add(new ArrayList<>(List.of(i - 1, j - 1)));
            }
        }

        if ((i + 1) < matrix.size()) {
            if ((j + 1) < matrix.get(i).size()) {
                neighbours.add(new ArrayList<>(List.of(i + 1, j + 1)));
            }
            if ((j - 1) >= 0) {
                neighbours.add(new ArrayList<>(List.of(i + 1, j - 1)));
            }

        }

        */

        return neighbours;
    }

    static void dfsIland(Integer i, Integer j, ArrayList<ArrayList<Integer>> matrix) {

        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(i, j, matrix);

        for (ArrayList<Integer> neighbour : neighbours) {
            int x = neighbour.get(0);
            int y = neighbour.get(1);
            int cell = matrix.get(x).get(y);
            if (cell == 1) {
                matrix.get(x).set(y, 2);
                dfsIland(x, y, matrix);
            }
        }
    }

    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
        int numOfIslands = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int cell = matrix.get(i).get(j);
                if (cell == 1) {
                    numOfIslands++;
                    dfsIland(i, j, matrix);
                }
            }
        }
        return numOfIslands;
    }


    static Integer maxIsland(Integer i, Integer j, ArrayList<ArrayList<Integer>> matrix) {

        int size = 1;

        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(i, j, matrix);

        for (ArrayList<Integer> neighbour : neighbours) {
            int x = neighbour.get(0);
            int y = neighbour.get(1);
            int cell = matrix.get(x).get(y);
            if (cell == 1) {
                matrix.get(x).set(y, 2);
                size += maxIsland(x, y, matrix);
            }
        }
        return size;
    }

    static Integer max_island_size(ArrayList<ArrayList<Integer>> matrix) {

        Integer island_size = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int cell = matrix.get(i).get(j);
                if (cell == 1) {
                    int size = maxIsland(i, j, matrix);
                    island_size = Math.max(size, island_size);
                }
            }
        }
        return island_size;
    }

    /*

    static int discover_basin(int i, int j, ArrayList<ArrayList<Integer>> matrix) {
        int size = 1;

        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(i, j, matrix);

        for (ArrayList<Integer> neighbour : neighbours) {
            int x = neighbour.get(0);
            int y = neighbour.get(1);

            if(matrix.get(x).get(y) )



        }

        return count_neighbour;
    }


    static ArrayList<Integer> find_basins(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<Integer> basins = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int basin_size = discover_basin(i, j, matrix);
                basins.add(basin_size);

            }
        }


    }

    */


    static void FloodFill(Integer i, Integer j, Integer old_color, Integer new_color, ArrayList<ArrayList<Integer>> image, int[][] visited) {
        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(i, j, image);

        for (ArrayList<Integer> neighbour : neighbours) {
            int x = neighbour.get(0);
            int y = neighbour.get(1);
            if (visited[x][y] != 1) {
                if (image.get(x).get(y) == old_color) {
                    image.get(x).set(y, new_color);
                    visited[x][y] = 1;
                    FloodFill(x, y, old_color, new_color, image, visited);
                }
            }
        }
    }

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        int[][] visited = new int[image.size()][image.get(0).size()];


        visited[pixel_row][pixel_column] = 1;

        int old_color = image.get(pixel_row).get(pixel_column);
        if (old_color == new_color) {
            return image;
        }

        image.get(pixel_row).set(pixel_column, new_color);
        FloodFill(pixel_row, pixel_column, old_color, new_color, image, visited);
        return image;
    }


    static ArrayList<ArrayList<Integer>> findKnightMoves(Integer rowSize, Integer colSize, Integer i, Integer j) {
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();

        if ((i - 2) >= 0) {
            if ((j - 1) >= 0) {
                moves.add(new ArrayList<>(List.of(i - 2, j - 1)));
            }
            if ((j + 1) < colSize) {
                moves.add(new ArrayList<>(List.of(i - 2, j + 1)));
            }
        }

        if ((i - 1) >= 0) {
            if ((j - 2) >= 0) {
                moves.add(new ArrayList<>(List.of(i - 1, j - 2)));
            }
            if ((j + 2) < colSize) {
                moves.add(new ArrayList<>(List.of(i - 1, j + 2)));
            }
        }

        if ((i + 1) < rowSize) {
            if ((j - 2) >= 0) {
                moves.add(new ArrayList<>(List.of(i + 1, j - 2)));
            }
            if ((j + 2) < colSize) {
                moves.add(new ArrayList<>(List.of(i + 1, j + 2)));
            }
        }

        if ((i + 2) < rowSize) {
            if ((j - 1) >= 0) {
                moves.add(new ArrayList<>(List.of(i + 2, j - 1)));
            }
            if ((j + 1) < colSize) {
                moves.add(new ArrayList<>(List.of(i + 2, j + 1)));
            }
        }
        return moves;
    }


    static Integer knightTraversal(Integer rowSize, Integer colSize, Integer start_row, Integer start_col, Integer
            end_row, Integer end_col) {

        int level = 0;
        boolean visited[][] = new boolean[rowSize][colSize];

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(List.of(start_row, start_col)));
        visited[start_row][start_col] = true;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            for (int l = 0; l < size; l++) {

                ArrayList<Integer> currMove = q.poll();
                ArrayList<ArrayList<Integer>> nextMoves = findKnightMoves(rowSize, colSize, currMove.get(0), currMove.get(1));
                for (ArrayList<Integer> nextMove : nextMoves) {
                    int ix = nextMove.get(0);
                    int iy = nextMove.get(1);
                    if (!visited[ix][iy]) {
                        if ((ix == end_row) && (iy == end_col)) {
                            return level;
                        }
                        visited[ix][iy] = true;
                        q.add(new ArrayList<>(List.of(ix, iy)));
                    }
                }
            }
        }
        return -1;
    }

    static Integer find_minimum_number_of_moves(Integer rows, Integer cols, Integer start_row, Integer
            start_col, Integer end_row, Integer end_col) {

        if ((start_row == end_row) && (start_col == end_col)) {
            return 0;
        }

        return knightTraversal(rows, cols, start_row, start_col, end_row, end_col);
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

        ArrayList<Integer> edge_start = new ArrayList<>();
        edge_start.add(0);
        edge_start.add(1);
        edge_start.add(1);
        edge_start.add(2);
        edge_start.add(3);

        ArrayList<Integer> edge_end = new ArrayList<>();
        edge_end.add(2);
        edge_end.add(2);
        edge_end.add(4);
        edge_end.add(3);
        edge_end.add(4);

        System.out.println(is_it_a_tree(5, edge_start, edge_end));
        System.out.println(can_be_divided(5, edge_start, edge_end));


        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(1, 1, 1)));
        matrix.add(new ArrayList<>(List.of(1, 1, 1)));
        matrix.add(new ArrayList<>(List.of(1, 1, 1)));

        //System.out.println(count_islands(matrix));
        //System.out.println(max_island_size(matrix));
        System.out.println("Flood Fill" + flood_fill(0, 0, 0, matrix));

        System.out.println(find_minimum_number_of_moves(5, 5, 0, 0, 4, 1));
    }

}
