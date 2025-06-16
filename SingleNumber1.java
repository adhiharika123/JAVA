import java.util.Scanner;

public class SingleNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Exactly once appeared number is :" + SingleNumber1(arr));
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

    //Approch 2 : Using XOR
    //XOR of same number results 0
    //XOR of a number with 0 results the number
    public static int SingleNumber1(int arr[]){
        int xor1=0;
        for(int i = 0 ; i < arr.length ; i++){
            xor1=xor1^arr[i];
        }
        return xor1;
    }
    
    
}
        

