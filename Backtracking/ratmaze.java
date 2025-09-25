package Java.Backtracking;

public class ratmaze{

    public static void printBoard(int path[][], int n){
        for(int i =0; i<n; i++){
            for(int j  = 0; j<n; j++){
                System.out.print(path[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
  

   public static boolean isSafe(int maze[][], int row, int col,int n){
    return (row>=0 && col>=0 && row<n && col<n && maze[row][col]==1);
   }   

    public static void ratMaze(int maze[][], int path[][], int row, int col, int n){
        //base case
        if(row==n-1 && col==n-1){
            path[row][col] = 1;
            printBoard(path,n);
            path[row][col] = 0;
            return;
        }

        if(!isSafe(maze, row, col, n) || path[row][col]==1){
            return;
        }

        //work
        path[row][col] = 1;

        //right
        ratMaze(maze, path, row, col+1, n);

        //down
        ratMaze(maze, path, row+1, col, n);

        //left
        ratMaze(maze, path, row, col-1, n);

        //up
        ratMaze(maze, path, row-1, col, n);

        path[row][col] = 0;
    }
    public static void main(String args[]){
        
        int maze[][] = {
            {1,0,0,0},
            {1,1,0,0},
            {0,1,1,0},
            {1,1,1,1}
        };
        int n = 4;
        int path[][] = new int[n][n];

        ratMaze(maze, path, 0, 0, n);
        
        
    }
}