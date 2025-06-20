//Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.


import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        List<Integer> result = majorityElement(nums);
        System.out.println("the majority elements are :");
        for(int x : result){
            System.out.print(x + " ");
        }
        
    }

    //BruteForce Approch 

    /* 
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> tmp= new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // Check after inner loop finishes
            if(count > (nums.length/3)) {
                if(!tmp.contains(nums[i])){
                    tmp.add(nums[i]);
                }
            }
        }
        return tmp;
    }
    */


    //Approch 2 : Optimal Approach (Extended Boyer Moore’s Voting Algorithm): 
    public static List<Integer> majorityElement(int nums[]){
        int n = nums.length;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int cnt1=0;
        int cnt2=0;
        for(int i = 0 ; i < n ; i++){
            if(cnt1 == 0 && el2 != nums[i]){
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2 == 0 && el1 != nums[i]){
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i] == el1) cnt1++;
            else if(nums[i] == el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        //Check for Final Count
        cnt1=0;
        cnt2=0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == el1) cnt1++;
            if(nums[i] == el2) cnt2++;
        }
        //Check if > n/3
        List<Integer> ls = new ArrayList<>();
        if(cnt1 > n/3){
            ls.add(el1);
        }
        if(cnt2 > n/3){
            ls.add(el2);
        }
        return ls;
    }
}
