import java.util.Scanner;

public class ChecktheNumberIsPowerOfZero {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        check(N);
    }
    public static void check(int N){
        if((N & (N - 1)) == 0){
            System.out.println("The Number is power of 2 ");
        }
        else{
            System.out.println("The Number is not a power of 2 ");
        }
    }
}
