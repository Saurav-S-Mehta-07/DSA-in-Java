package LC;
public class powerOfThree {

    public static boolean isPowerOfThree(int n){
        if(n<1) return false;
        while(n%3==0)n/=3;
        return n==1;
    }
    public static void main(String[] args) {
        int n = 81;
        System.out.println(isPowerOfThree(n));
    }
}
