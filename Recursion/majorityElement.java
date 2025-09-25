public class majorityElement {

    public static int majorElement(int arr[]){
        int candidate = arr[0];
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(candidate==arr[i]){
                count++;
            }else{
                count--;
            }
            if(count<=0){
                candidate = arr[i+1];
            }
        }
        return candidate;
    }
    public static void main(String[] args){
       int arr[] = {2,2,1,1,1,2,2};
       System.out.println(majorElement(arr));
    }
}
