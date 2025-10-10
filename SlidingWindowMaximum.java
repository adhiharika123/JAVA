import java.util.*;
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n valaue : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter k valaue : ");
        int k = sc.nextInt();
        int result[] = maxSlidingWindow(nums, k);
        for(int res : result){
            System.out.print(res + " ");
        }
    }
    //Brute Force Approach
    /*
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> maxx = new ArrayList<>();
        int left = 0;
        int right = 0;
        int i,j;
        while(right < k-1){
            right++;
        }
        while(right < nums.length){
            GetMax(nums, left, right, maxx);
            left++;
            right++;
        }
        int result[] = new int[maxx.size()];
        for( j = 0; j < maxx.size(); j++){
            result[j] = maxx.get(j);
        }
        return result;
    }
    public static void GetMax(int nums[], int left, int right,        ArrayList<Integer> maxx){
        int i, maxi = Integer.MIN_VALUE;
        for(i = left; i <= right; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        maxx.add(maxi);
    }
    */

    //Optimal Approach
    public static int[] maxSlidingWindow(int nums[], int k){
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            //  Remove indices out of the window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            //  Remove smaller elements (from back). Becauase they will be never be needed - current num
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1){
                res.add(nums[dq.peekFirst()]);
            }
        }
        //Convert ArrayList to Array
        int ans[] = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
