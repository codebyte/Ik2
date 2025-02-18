package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    static int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        for (int r = 0; r < directions.length; r++) {
            int x = directions[r][0] + i;
            int y = directions[r][1] + j;
            if ((x >= 0) && (x < grid.length) && (y >= 0) && (y < grid[0].length)) {
                if (grid[x][y] == '1') {
                    dfs(grid, x, y);
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '2') {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }


    public static ArrayList<ArrayList<Integer>> getNeighbours(char[][] board, int i, int j) {

        boolean found = true;
        ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();
        for (int x = 0; x < directions.length; x++) {
            int xi = directions[x][0] + i;
            int yj = directions[x][1] + j;
            if ((xi >= 0) && (xi < board.length) && (yj >= 0) && (yj < board[0].length)) {
                if (board[xi][yj] == 'X') {
                    found = true;
                }
                neighbours.add(new ArrayList<>(List.of(xi, yj)));
            }

            if (!found) {
                return new ArrayList<>();
            }
        }

        return neighbours;
    }


    public static void surround(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(board, i, j);

        if (neighbours.size() != 4) {
            return;
        }
        board[i][j] = 'X';

        neighbours.forEach(pair -> {
            int x = pair.get(0);
            int y = pair.get(1);
            if ((!visited[x][y]) && (board[x][y] == 'O')) {
                surround(board, x, y, visited);
            }
        });
    }

    public static void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        ArrayList<ArrayList<Integer>> mask = new ArrayList<>();

        for (int i = 0; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '#';
            }
            if (board[board.length - 1][i] == 'O') {
                board[board.length - 1][i] = '#';
            }

        }

        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
            }
            if (board[i][board.length - 1] == 'O') {
                board[i][board.length - 1] = '#';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((!visited[i][j]) && (board[i][j] == 'O')) {
                    surround(board, i, j, visited);
                }
            }
        }

        for (int i = 0; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '#';
            }
            if (board[board.length - 1][i] == '#') {
                board[board.length - 1][i] = 'O';
            }

        }

        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
            }
            if (board[i][board.length - 1] == '#') {
                board[i][board.length - 1] = 'O';
            }
        }
    }





    public static void main(String args[]) {

        char grid[][] = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}};
        System.out.println(numIslands(grid));
        char board[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        for (int i = 0; i < board.length; i++)
            System.out.println(Arrays.toString(board[i]));
        solve(board);
        for (int i = 0; i < board.length; i++)
            System.out.println(Arrays.toString(board[i]));

    }
}
