//minimum time to rot all oranges
package Graphs;
import java.util.*;

class RottenOranges {
    static class Pair {
        int row, col;
        Pair(int r, int c) { row = r; col = c; }
    }

    public static int minTimeToRotAllOranges(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new Pair(i, j));
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0; 

        int time = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisRound = false;

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int r = p.row + dRow[d];
                    int c = p.col + dCol[d];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new Pair(r, c));
                        fresh--;
                        rottenThisRound = true;
                    }
                }
            }

            if (rottenThisRound) time++;
        }

        return (fresh == 0) ? time : -1;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {2, 1, 0, 2, 1},
            {0, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };

        int result = minTimeToRotAllOranges(arr);
        if (result == -1) System.out.println("All oranges cannot be rotten.");
        else System.out.println("Minimum time to rot all oranges: " + result);
    }
}
