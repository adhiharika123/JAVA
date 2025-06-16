import java.util.HashSet;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The missing element is:"+Missing(arr,n));
    }
    /*
    Approch 1 : Using HashSet
    
    public static int Missing(int arr[], int n){
        HashSet<Integer> s = new HashSet<>();
        for(int i : arr){
            s.add(i);
        }
        for(int i = 0 ; i <= n ; i++){
            if(!s.contains(i)){
                return i;
            }
        }
        return -1;
    }
    */

    /*
     Approch 2 : Sum of elements 

    public static void Missing(int arr[], int n){
        int sum1;
        int sum2 = 0;
        sum1=n*(n+1)/2;
        for(int i = 0 ; i < n ; i++){
            sum2 += arr[i];
        }
        int m=sum1-sum2;
        System.out.print("The missing element is:" + m);
    }
     */
    public static int Missing(int arr[], int n){
        int xor1=0;
        int xor2=0;
        for(int i = 0 ; i < n ; i++){
            xor1=xor1^arr[i];
        }
        for(int i = 0 ; i <= n ; i++){
            xor2=xor2^i;
        }
        return(xor1^xor2);

}
}