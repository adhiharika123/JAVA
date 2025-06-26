import java.util.*;
public class MissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = MissingAndRepeating(arr, n);
        System.out.println("Repeating: " + result[0]);
        System.out.println("Missing: " + result[1]);
    }
    //Approch 1 : Brute Force TC : O(N)^2;
    /* 
    public static int[] MissingAndRepeating(int arr[], int n){
        int repeating = 0;
        int missing = 0;
        for(int i = 1; i <= n ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(arr[j] == i) count++;
            }
            if(count == 2)  repeating = i;
            if(count == 0) missing = i;
        }
        int ans[] = {repeating, missing};
        return ans;
    }
    */

    //Approch 2 : Using Hashing TC: O(2N)
    /* 
    public static int[] MissingAndRepeating(int arr[], int n){
        int count[] = new int[n+1];
        int repeating = 0; int missing = 0;
        for(int num :arr){
            count[num]++;
        }
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 2) repeating = i;
            else if(count[i] == 0) missing = i;
        }
        int ans[] = {repeating, missing};
        return ans;
    }
    */

    //Approch 3 : Using XOR TC: O(1)
    public static int[] MissingAndRepeating(int arr[], int n){
        long SN = n*(n+1)/2 ; //Sum of First N natural Numbers
        long S2N = n*(n+1)*(2*n+1)/6 ; //Sum of Squares of First N natural Numbers
        //S-SN
        //S2-S2N
        long S = 0 , S2 = 0;
        for(int i = 0 ; i < n ; i++){
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }
        long val1 = S-SN; //X-Y
        long val2 = S2-S2N;
        val2 = val2/val1; //X+Y;  //X^2 - Y^@ = (X+Y)*(X-Y)
        long X = (val1+val2)/2;
        long Y = X - val1;
        return new int[] {(int) X, (int) Y};
    }
}
