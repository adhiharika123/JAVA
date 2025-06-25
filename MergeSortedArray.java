import java.util.*;
public class MergeSortedArray {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
        System.out.println("Enter nums1 value: ");
		int n1 = sc.nextInt();        
		int nums1[] = new int[n1];
        System.out.println("Enter array elements: ");
		for(int i = 0 ; i < nums1.length ; i++){
			nums1[i]=sc.nextInt();
		}
		System.out.println("Enter m value : ");
		int m = sc.nextInt();
        //System.out.println("Enter nums2 value: ");
		//int n2 = sc.nextInt();        		
        System.out.println("Enter array elements: ");
        int nums2[] = new int[m];
		for(int i = 0 ; i < nums2.length ; i++){
			nums2[i]=sc.nextInt();
		}
        MergeArray(nums1,nums2,n,m);

        
    }
    public static void MergeArray(int[] nums1, int[] nums2, int n, int m){
    //Approch 1 Brute Force By using Extra space as nums3

        /*
        int nums3[] = new int[n+m];
        int left = 0;
        int right = 0;
        int index = 0;
        while(left< n && right <m){
            if(nums1[left]<nums2[right]){
                nums3[index]=nums1[left];
                left++;
                index++;
            }
            else{
                nums3[index]=nums2[right];
                right++;
                index++;
            }
        }

        //Leftover elements
        while(left < n){
            nums3[index++] = nums1[left++];
        }
        while(right < m){
            nums3[index++] = nums2[right++];
        }

        //Fill back from nums3 to nums1 and nums2
        for(int i = 0 ; i < n + m ; i++){
            if(i < n){
                nums1[i]=nums3[i];
            }
            else{
                nums2[i-n]=nums3[i];
            }
        }
        System.out.println("The merged arrays are:");
        System.out.print("nums1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.print("\nnums2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();

    }
    */

    //Approch 2 Better Approch without Extra space using Swap
        int left = n-1;
        int right = 0;
        while(left >= 0 && right < m){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            }
            left--;
            right++;
        }
        Arrays.sort(nums1,0,n);
        Arrays.sort(nums2);
        System.out.println("The merged arrays are :");
        System.out.print("nums1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.print("\nnums2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
        //To Merge Entire Array
        System.out.println("The Entire Merged Sorted Array is:");
        for(int i = 0 ; i < n ; i++){
            nums1[m+i] = nums2[i];
        }
        for (int i = 0; i < n+m ; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

}