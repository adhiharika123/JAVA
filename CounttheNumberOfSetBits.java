import java.util.Scanner;

public class CounttheNumberOfSetBits {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        int result = countSetBits(N);
        System.out.println("The Count of Set Bits is : " + result);
    }
    public static int countSetBits(int N){
        int count = 0;
        /* 
        while( N > 1){
            if(N % 2 == 1) count++;
            N = N / 2;
        }
        if(N == 1) count++;
        return count;
        */

        //Better Approach
        /* 
        while(N > 1){
            count += N & 1;     //The Last Bit Of Odd Number is always Set(i.e., 1)
            N = N >> 1;         //Performing (N / 2)
        }
        if(N == 1) count += 1;
        return count;
        */

        //Optimal Approach
        while(N != 0){
            N = N & (N-1);      //At Each time we are turning off the rightmost Set Bit 
            count++;
        }
        return count;
    }
}
