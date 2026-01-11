package Practice;

public class PrintAllSubArray{
    public static void allSubArrays(int[] arr){
        int n = arr.length;
        int totalSubArrays = 0;
        totalSubArrays = (n * (n+1))/2;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                for(int k = i; k<=j; k++){
                    System.err.print(arr[k] + " ");
                }
                System.out.println(" ,");
            }
            System.out.println();
        }
        System.out.println("total subarray = " + totalSubArrays);
    }

    public static void main(String [] args){
        int arr[] = {2,4,6,8,10};
        allSubArrays(arr);
    }
}