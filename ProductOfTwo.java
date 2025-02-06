import java.util.Scanner;

public class ProductOfTwo {
     public static int Mul(int n1, int n2){
        return n1*n2;
    }

    public static void main(String[] args) {
        System.out.println("Enter two(2) numbers :");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println("Product of two numbers is: " + Mul(n1,n2));
    }
}
