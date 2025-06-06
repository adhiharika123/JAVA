import java.util.*;

public class OntToN {
    public static void NumbersPrint(int i,int n){
        while(i<=n){
            System.out.println(i);
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n= sc.nextInt();
        System.out.println("The numbers are from 1 to N:");
        NumbersPrint(1, n);
    }
}
