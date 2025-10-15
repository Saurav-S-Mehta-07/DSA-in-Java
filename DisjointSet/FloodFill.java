//leetcode que 733
package DisjointSet;

public class FloodFill {

    public static class Pair{
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    //O(n*m)
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol){
        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[0].length-1 || vis[sr][sc] || image[sr][sc]!=orgCol){
            return;
        }
        vis[sr][sc]= true;
        image[sr][sc] = color;
        //left
        helper(image, sr, sc-1, color, vis, orgCol);
        //right
        helper(image, sr, sc+1, color, vis, orgCol);
        //up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);
    }

    public static int[][] colorImage(int[][] image, int sr, int sc, int color){
         if (image[sr][sc] == color) return image;
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
               {1,1,1},
               {1,1,0},
               {1,0,1}        
        };

        int sr=1, sc = 1, color = 2;

        colorImage(image,sr,sc,color);

        for(int []row : image){
            for(int i : row){
                System.out.print(" " + i);
            }
            System.out.println();
        }

    }
}
