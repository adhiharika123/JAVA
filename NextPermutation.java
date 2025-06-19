//Permutations : ReArrangement of elements in possible orders.
import java.util.*;
public class NextPermutation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i]=sc.nextInt();
        }
        Rearrange(nums , n);
        System.out.println("Next permutation is :");
        for(int i = 0 ; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void Rearrange(int nums[], int n){
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums,i+1,n-1);
    }
    public static void swap(int nums[], int i , int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int nums[], int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
} 