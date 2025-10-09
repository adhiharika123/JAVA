import java.util.*;

public class NextSmallerElement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums1[] = new int[n];
        for(int i = 0; i < n; i++){
            nums1[i] = sc.nextInt();
        }
        int nums2[] = nextSmallerElement(nums1);
        System.out.println("The next smaller elements are : ");
        for(int j = 0; j < n; j++){
            System.out.print(nums2[j] + " ");
        }
    }

    //  Brute Force 
    /*
    public static int[] nextSmallerElement(int nums1[]){
        int n = nums1.length;
        int nse[] = new int[n];
        Arrays.fill(nse, -1);
        
        for(int i = 0; i < n; i++){
            int currElem = nums1[i];
            for(int j = i+1; j < n; j++){
                if(nums1[j] < currElem){
                    nse[i] = nums1[j];
                    break;
                }
                else{
                    nse[i] = -1;
                }
            }
        }
        return nse;
    }
    */

    //  Optimal Approch
    public static int[] nextSmallerElement(int nums1[]){
        int n = nums1.length;
        Stack<Integer> st = new Stack<>();
        
        int nse[] = new int[n];
        Arrays.fill(nse, -1);
        

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() >= nums1[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i] = st.peek();
            }
            st.push(nums1[i]);
        }
        return nse;
    }
}
