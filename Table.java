import java.util.*;
public class Table {
    public static void PrintTable(int n){
        for(int i=0;i<=10;i++){
            System.out.println(n+"x"+ i +"="+ n*i);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Multiplication Table of " + n);
        PrintTable(n);
    }
}
