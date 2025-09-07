import java.util.Scanner;

public class CheckithbitSetorNot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Check ith bit Set or Not : ");
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        System.out.println("The i value is : ");
        int i = sc.nextInt();
        check(N,i);
    }

    public static void check(int N , int i){
        //BruteForce
        //Convert Decimal to Binary
        for(int j = 0 ; j < i ; j++){
            N = N / 2;
        }
        //Checking the last bit 
        if(N % 2 == 1){
            System.out.println("The bit is set");
        }
        else{
            System.out.println("The bit is not set");
        }
    }

    /* 
    public static void check(int N , int i){
        //Left Shift Operator
        /* 
        if((N & (1 << i)) != 0){
            System.out.println("The bit is set");
        }
        else{
            System.out.println("The bit is not set");
        }
        

        //Right Shift Operator
        if(((N >> i) & 1) != 0){
            System.out.println("The bit is set");
        }
        else{
            System.out.println("The bit is not set");
        }
    }
    */
}
