import java.util.*;
public class MergetwoSortedArrays{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nums1 length");
        int n1 = sc.nextInt();
        System.out.println("Enter nums2 length");
        int n2 = sc.nextInt();
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
        System.out.println("The Median of two merged sorted arrays is : " + findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //Brute Force
        /*
        int a = nums1.length;
        int b = nums2.length;
        List<Integer> nums3 = new ArrayList<Integer>();
        
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

        //Find Median
        int n = a + b;
        if(n % 2 == 1){
            return (double) nums3.get(n/2);  // If n is odd
        }
        double median = ((double) nums3.get(n/2) + (double) nums3.get((n/2) - 1))/2.0;  //If n is even
        return median;
        */

        //Optimal - Binary Search
        int a = nums1.length;
        int b = nums2.length;
        //Condition check to swap
        if(a > b) return findMedianSortedArrays(nums2,nums1);

        int n = a + b; //total length
        int left = (a+b+1)/2; //Left half length

        int low = 0;
        int high = a;
        while(low <= high){
            int mid1 = (low+high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < a) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < b) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1) return Math.max(l1,l2);
                else return ((double) (Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
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