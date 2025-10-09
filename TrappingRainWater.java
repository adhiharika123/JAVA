/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining. */

import java.util.*;
public class TrappingRainWater{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n valaue : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int height[] = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = sc.nextInt();
        }
        int result = trap(height);
        System.out.println("The water it can trap after raining is : " + result);
    }

    //  Brute Force TC : O(n)^2
    /* 
    public static int trap(int height[]){
        int result = 0;
        for(int i = 0; i < height.length; i++){
            int left = height[i];
            for(int j = 0; j < i; j++){
                left = Math.max(left, height[j]);
            }
            int right = height[i];
            for(int j = i+1; j < height.length; j++){
                right = Math.max(right, height[j]);
            }
            result += Math.min(left, right) - height[i];
        }
        return result;
    }
    */

    //Optimal Approach 
    public static int trap(int[] height){
        int n = height.length;
        int result = 0;
        int left = 0;
        int right = n-1;
        int leftmax = 0, rightmax = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftmax){
                    leftmax = height[left];
                }
                else{
                    result += leftmax - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= rightmax){
                    rightmax = height[right];
                }
                else{
                    result += rightmax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}