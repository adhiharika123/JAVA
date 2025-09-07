import java.util.Scanner;

public class Set_ithbit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Check ith bit Set or Not : ");
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        System.out.println("The i value is : ");
        int i = sc.nextInt();
        set(N,i);
    }
    public static void set(int N, int i){
        int result = (N | (1 << i));
        System.out.println("The result after setting the ith bit is : " + result);
    }
}
