/* Problem Statement: Given a circular integer array A, return the next greater element for every element in A. 
The next greater element for an element x is the first element greater than x that we come across while traversing 
the array in a clockwise manner. If it doesn't exist, return -1 for this element.
*/
import java.util.*;
public class NextGreaterElement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums1[] = new int[n];
        for(int i = 0; i < n; i++){
            nums1[i] = sc.nextInt();
        }
        int nums2[] = nextGreaterElement(nums1);
        System.out.println("The next greater elements are : ");
        for(int j = 0; j < n; j++){
            System.out.print(nums2[j] + " ");
        }
    }
    public static int[] nextGreaterElement(int nums1[]){
        int n = nums1.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 2*n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums1[i%n]){
                st.pop();
            }
            if(i < n){
                if(!st.isEmpty()){
                    nge[i] = st.peek();
                }
                else{
                    nge[i] = -1;
                }
            }
            st.push(nums1[i%n]);
        }
        return nge;
    }
}