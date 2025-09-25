

public class quePairing {

    public static int tilingProblem(int n){ //2 x n(floor size);
        //base case
        if(n==0|| n==1){
            return 1;
        }
        return tilingProblem(n-1) + tilingProblem(n-2);
    }

    public static StringBuilder removeDuplicate(String str, int idx, StringBuilder newStr, boolean[] map) {
        if (idx == str.length()) {
            return newStr;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a']) {
            // duplicate, skip
            return removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            return removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendsPariring(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendsPariring(n-1) + (n-1)*friendsPariring(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, String str){
        //base case 
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinStrings(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinStrings(n-1, 1, str+"1");
        }
        
    }

    public static void printIndices(int arr[],int i, int key){
           if(i==arr.length){
            return;
           }
           if(key==arr[i]){
            System.out.print(i +"  ");
           }
           printIndices(arr, i+1, key);
    }

    public static void numberToStr(String str[],  int n){
            if(n==0){
                return;
            }
            numberToStr(str, n/10);
            System.out.print(str[n%10]+ " ");
    }

    public static int lengthStr(String str){

        if(str.length() == 0){
            return 0;
        }

        return lengthStr(str.substring(1)) + 1;

    }


    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("transfer disk "+ n+" from "+src+" to "+dest);
            return;
        }

        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("transfer disk "  + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        
    }
}
