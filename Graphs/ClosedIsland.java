
import java.util.*;

public class ClosedIsland {
    
    static int n, m;
    
    public static void dfs(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == 0)
            return;
        mat[i][j] = 0; // mark as visited (turn land into water)
        dfs(mat, i + 1, j);
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i, j - 1);
    }
    
    public static int closedIslands(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        // Step 1: Eliminate lands connected to boundaries
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1) dfs(mat, i, 0);
            if (mat[i][m - 1] == 1) dfs(mat, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 1) dfs(mat, 0, j);
            if (mat[n - 1][j] == 1) dfs(mat, n - 1, j);
        }

        // Step 2: Count closed islands
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dfs(mat, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println(closedIslands(mat1)); // Output: 1

        int[][] mat2 = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,1,1,0,0,1},
            {0,1,0,1,0,0,0,1},
            {0,1,1,1,1,0,1,0},
            {0,0,0,0,0,0,0,1}
        };
        System.out.println(closedIslands(mat2)); // Output: 2
    }
}
