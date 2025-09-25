import java.util.*;
import java.util.LinkedList;

public class KnightMoves {
    
    // Knight move offsets
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // Check if knight is inside board
    static boolean isInside(int x, int y, int N) {
        return (x >= 1 && x <= N && y >= 1 && y <= N);
    }

    // BFS to find min steps
    static int minSteps(int[] knightPos, int[] targetPos, int N) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Cell> q = new LinkedList<>();

        // Start position
        q.add(new Cell(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            // Target reached
            if (curr.x == targetPos[0] && curr.y == targetPos[1]) {
                return curr.dist;
            }

            // Try all 8 moves
            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if (isInside(newX, newY, N) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    q.add(new Cell(newX, newY, curr.dist + 1));
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int N = 30;
        int[] knightPos = {1, 1};
        int[] targetPos = {30,30};

        System.out.println("Minimum steps: " + minSteps(knightPos, targetPos, N));
    }
}
