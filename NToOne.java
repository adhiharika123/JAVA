import java.util.Scanner;

public class NToOne {
    public static void NumbersPrint(int i,int n){
        while(i>0){
            System.out.println(i);
            i--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n= sc.nextInt();
        System.out.println("The numbers are from 1 to N:");
        NumbersPrint(n, n);
    }
}
