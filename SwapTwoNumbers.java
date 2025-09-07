import java.util.*;
class SwapTwoNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Swapping Two numbers : ");
        System.out.println("The a value is : ");
        int a = sc.nextInt();
        System.out.println("The b value is : ");
        int b = sc.nextInt();
        swap(a, b);
    }
    public static void swap(int a, int b){
        //Using Third variable
        /* 
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
        System.out.println("The a value is : " + a);
        System.out.println("The b value is : " + b );
        */

        //Using Addition and Subtraction
        /* 
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("The a value is : " + a);
        System.out.println("The b value is : " + b );
        */

        //Using Bitwise XOR(^) Operation
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("The a value is : " + a);
        System.out.println("The b value is : " + b );
    }
}