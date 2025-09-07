import java.util.Scanner;

public class RemovethelastSetDigit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        remove(N);
    }
    public static void remove(int N){
        int result = (N & (N - 1));
        System.out.println("The result after removing the ith bit is : " + result);
    }
}
