import java.util.Scanner;

public class Clear_ithbit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The N value is : ");
        int N = sc.nextInt();
        System.out.println("The i value is : ");
        int i = sc.nextInt();
        clear(N,i);
    }
    public static void clear(int N, int i){
        int result = (N & ~(1 << i));
        System.out.println("The result after clearing the ith bit is : " + result);
    }
}
