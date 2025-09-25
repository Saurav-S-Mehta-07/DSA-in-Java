
public class bitManip{

    public static int oddEven(){
       int n = 15;
      int bitMask = 1;
      if((n&bitMask)==0){
        return 0;
      }else{
        return 1;
      }
    }

    public static int getithBit(int n, int i){
         int bitMask = 1<<i;
         if((n&bitMask)==0){
           return 0;
         }else{
          return 1;
         }
    }

    public static int setithBit(int n, int i){
      int bitMask = 1<<i;
      return n|bitMask;
    }

    public static int clearithBit(int n, int i){
      int bitMask = ~(1<<i);
      return n&bitMask;
    }

    public static int updateithBit(int n, int i, int newBit){
      // if(newBit == 0){
      //   return clearithBit(n,i);
      // }else{
      //   return setithBit(n, i);
      // }

      n = clearithBit(n, i);
      int bitMask = newBit<<i;
      return n|bitMask;
    }

    public static int clearithBits(int n, int i){
      int bitMask = (-1)<<i;
      return n & bitMask;
    }

    public static int clearRangeBits(int n, int i, int j){
      int a = ((~0)<<(j+1));
      int b = (1<<i)-1;
      int bitMask = a|b;
      return n&bitMask;
    }

    public static boolean noPowofTwo(int n){
      return (n&(n-1))==0;
    }

    public static int countSetBits(int n){
      int count = 0;
      while(n>0){
        if((n & 1)!=0){//lsb
          count++;
        }
        n = n>>1;
      }
      return count;
    }

    public static int fastExpo(int a, int n){
      int ans = 1;

      while(n>0){
        if((n&1)!=0){
          ans = ans*a;
        }
        a = a*a;
        n = n>>1;
      }
      return ans;
    }
    public static void main(String args[]){
      System.out.println(fastExpo(5,3));
    }

}
