package Java.Backtracking;

public class subset {

    public static void findSubset(String str, int i, String ans){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.print("null"+ " ");
            }
            else{
                System.out.print(ans + "  ");
            }
            return;
        }
        //recursion
        //Yes choice
        findSubset(str, i+1, ans+str.charAt(i));
        //No choice
        findSubset(str, i+1, ans);   
    }

    public static void main(String args[]){

        findSubset("abc", 0,"");

    }

}