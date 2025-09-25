
public class shortestPath {

    public static void  getshortestPath(String str){
          int x = 0, y = 0;
          for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='W'){
                x--;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='E'){
                x++;
            }
            else{
                System.out.println("direction is invalid");
                return;
            }
          }
          
          x = (int)Math.pow(x,2);
          y = (int)Math.pow(y,2);

          float path = (float)Math.sqrt(x+y);

          System.out.println("shortest path : "+ path );

    }
    public static void main(String args[]){
         String str = "WNEENESENNN";
         getshortestPath(str);
    }
}
