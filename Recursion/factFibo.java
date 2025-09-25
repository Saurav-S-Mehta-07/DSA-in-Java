
public class factFibo {
    
    public static void printInc(int n){
        if(n==1){
             System.out.print(n+ " ");
             return;
        }
        printInc(n-1);
        System.out.print(n+ " ");

    }

    public static void printDcr(int n){
        if(n==1){
             System.out.print(n+ " ");
             return;
        }
        System.out.print(n+ " ");
        printDcr(n-1);
    }

    public static int fact(int n, int a){
        if(n==0){
            return a;
        }
        return fact(n-1,n*a);
    }

    public static int sum(int n){ //TC:O(n), SC: O(n)
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }

    public static int fibonacci(int n){ // TC: O(2^n), SC: O(n)
        if(n==0 || n==1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOcc(int arr[], int i, int key){
         if(i==arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOcc(arr, i+1, key);
    }

    public static int lastOcc1(int arr[], int i, int key){
        if(i == arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return lastOcc1(arr, i-1, key);
    }

    public static int lastOcc2(int arr[], int i, int key){
          if(i==arr.length){
            return -1;
          }
          int isFound = lastOcc2(arr, i+1, key);
          if(isFound == -1 && arr[i]==key){
            return i;
          }
          return isFound;
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x * power(x, n-1);
    }

    public static int optimizedPower(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPowerSq = optimizedPower(x, n/2);
        halfPowerSq = halfPowerSq*halfPowerSq;

        //n is odd
        if(n%2 != 0){
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }
    public static void main(String args[]){
         System.out.println(optimizedPower(2, 10));
    }
}
