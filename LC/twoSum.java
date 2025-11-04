package LC;
//find sum of 2 nums without +,-
public class twoSum {

    public static int findSum(int a, int b){
        while(b!=0){
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(findSum(a,b));
    }
}