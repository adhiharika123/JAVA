import java.util.Scanner;

public class ChecktheNumberIsOdd {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        check(N);
    }
    public static void check(int N){
        if((N & 1) == 1){
            System.out.println("The Number is Odd ");
        }
        else{
            System.out.println("The Number is not Odd");
        }
    }
}
