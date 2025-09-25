
import java.util.*;

public class palindrome {
    public static void main(String args[]){
        char arr[] = {'a', 'b', 'c', 'd'};
        String str1 = "abcd";
        String str2 = new String("xyz");
        //Strings are immutable;
        
        Scanner sc = new Scanner(System.in);
        String name;
         name = sc.nextLine();
         int flag = 0;
         for(int i = 0; i<name.length()/2; i++){
            if(name.charAt(i)!=name.charAt(name.length()-i-1)){
                flag = 1;
                System.out.println("not palicdrome");
                break;
            }
         }
         if(flag == 0)
             System.out.println("palindrome");
    }
}
