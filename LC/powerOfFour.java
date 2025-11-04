package LC;

public class powerOfFour {

    public static boolean isPowerOfFour(int n){
        //true is n>0, and power of 2 and even pos must be one
        //0x55555555 (hexadecimal no.) => 01010101010101010101010101010101
        return n>0 && (n&(n-1))==0 && (n & 0x55555555)!=0;
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}
