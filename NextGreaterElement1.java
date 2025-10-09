/* Problem Statement: The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
*/
import java.util.*;
public class NextGreaterElement1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n1 value : ");
        int n1 = sc.nextInt();
        System.out.println("Enter nums1 array elements : ");
        int nums1[] = new int[n1];
        for(int i = 0; i < n1; i++){
            nums1[i] = sc.nextInt();
        }
        System.out.println("Enter n2 value : ");
        int n2 = sc.nextInt();
        System.out.println("Enter nums2 array elements : ");
        int nums2[] = new int[n2];
        for(int i = 0; i < n2; i++){
            nums2[i] = sc.nextInt();
        }
        int result[] = nextGreaterElement(nums1, nums2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

    }
    public static int[] nextGreaterElement(int nums1[], int nums2[]){
        int n = nums2.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nge[i] = st.peek();
            }
            else{
                nge[i] = -1;
            }
            st.push(nums2[i]);
            map.put(nums2[i],nge[i]);
        }
        //  Build result
        int result[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}