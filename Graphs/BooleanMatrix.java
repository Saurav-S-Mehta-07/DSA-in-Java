
package Graphs;

public class BooleanMatrix {
    public static int ROW, COL;

    public static int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int dfs(int[][] mat, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int size = 1; 

        for (int d = 0; d < 8; d++) {
            int newRow = r + rowDir[d];
            int newCol = c + colDir[d];

            if (newRow >= 0 && newRow < ROW && newCol >= 0 && newCol < COL
                  && mat[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                size += dfs(mat, visited, newRow, newCol);
            }
        }
        return size;
    }

    public static int largestRegion(int[][] mat) {
        ROW = mat.length;
        COL = mat[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int maxSize = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(mat, visited, i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1}
        };

        System.out.println("Largest region size: " + largestRegion(mat));
    }
}
