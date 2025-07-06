import java.util.*;

public class KthElementOfTwoSortedArrays {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nums1 length");
        int n1 = sc.nextInt();
        System.out.println("Enter nums2 length");
        int n2 = sc.nextInt();
        System.out.println("Enter k value:");
        int k = sc.nextInt();
        System.out.println("Enter nums1 elements:");
        int nums1[] = new int[n1];
        for(int i = 0 ; i < n1 ; i++){
            nums1[i] = sc.nextInt();
        }
        System.out.println("Enter nums2 elements:");
        int nums2[] = new int[n2];
        for(int i = 0 ; i < n2 ; i++){
            nums2[i] = sc.nextInt();
        }
        System.out.println("The Kth Element Of two Sorted Arrays is : " + findMedianSortedArrays(nums1,nums2,k));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2, int k) {
        
        //Brute Force
        /*
        int a = nums1.length;
        int b = nums2.length;
        ArrayList<Integer> nums3 = new ArrayList<Integer>();
        
        //Merge two sorted arrays
        int i = 0, j = 0 ;
        while(i < a && j < b){
            if(nums1[i] <= nums2[j]){
                nums3.add(nums1[i]);
                i++;
            }
            else{
                nums3.add(nums2[j]);
                j++;
            }
        }
        //Add leftout elements  
        while(i < a){
            nums3.add(nums1[i++]);
        }
        while(j < b){
            nums3.add(nums2[j++]);
        }
        return nums3.get(k-1);

        */
        
        //Optimal - Binary Search
        int a = nums1.length;
        int b = nums2.length;
        //Condition check to swap
        if(a > b) return findMedianSortedArrays(nums2,nums1,k);

        int n = a + b; //total length
        int left = k; //Left half length

        int low = Math.max(0,k-b);  //How many minimum elements should we take from nums1
        int high = Math.min(k,a);     //How many maximum elements should we take from nums2
        while(low <= high){
            int mid1 = (low+high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < a) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < b) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }
            else if(l1 > r2){
                high = mid1 -1 ;   //i.e., more elements taken from nums1 so we require smaller x value 
            }
            else{
                low = mid1 + 1 ;  //i.e., more elements are taken from nums2 so we require larger x value
            }
        }
        return 0;
    }
}
