package Java.Arrays;

// import java.util.*;

public class trapWater {
       
    public static int trappedRainwater(int height[]){
        int n = height.length;
        //calculate left max boundary - array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i<n; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        //calculate right max boundary - array
        int rightMax[] = new int[height.length];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        //loop
        int trappedWater = 0;
        for(int i = 0; i<n; i++){
           //waterLevel = min (leftmax bound, rightmax bound)
           int waterLevel = Math.min(leftMax[i], rightMax[i]);
           //trapped water = waterlevel - height[i]
           trappedWater+=waterLevel-height[i];
        }

        return trappedWater;
    }

    //public static int trappedRainwater(int height[]){
    //     int n = height.length;
    //     int l = 0, r = n-1, res = 0;
    //     int lMax = height[l], rMax = height[r];
    //     while(l<r){
    //         if(lMax<rMax){
    //             l++;
    //             lMax = Math.max(lMax, height[l]);
    //             res+=lMax-height[l];
    //         }else{
    //             r--;
    //             rMax = Math.max(rMax, height[r]);
    //             res+=rMax-height[r];
    //         }
    //     }
    //       return res;
    // }
  
    public static void main(String args[]){
        int[] height = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};


        int res = trappedRainwater(height);
        System.out.println(res);
    }
    
}