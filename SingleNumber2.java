//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

//You must implement a solution with a linear runtime complexity and use only constant extra space.

import java.util.Scanner;

public class SingleNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Exactly once appeared number is :" + SingleNumber2(arr));
    }

    //Approch 1 : Using Frequency

    /*
    public static int SingleNumber1(int[] arr) {
        for(int i = 0 ; i < nums.length ; i++){
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++){
                if(nums[i] == nums[j] ){
                    count ++;
                }
            }
            if (count == 1) return nums[i];
        }
        return -1;
    }
    */

    //Approch 2 : Using Bit Manipulation

    public static int SingleNumber2(int arr[])
    {
        int ones = 0;
        int twos = 0 ;
        for(int num : arr){
            // First appearance: add num to ones
            // Second appearance: remove num from ones, add to twos
            // Third appearance: remove num from both ones and twos
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
        }
    }

