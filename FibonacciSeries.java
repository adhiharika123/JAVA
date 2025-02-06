import java.util.*;
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int n=sc.nextInt();
        if(n==0){
            System.out.println("Please enter a valid number....!");
            return;
        }
        int a=0;
        System.out.print(a + " ");
        int b=1;       
        if(n>1){
            System.out.print(b + " ");
        }
        for(int i=2;i<n;i++){     
            int temp=a+b;
            System.out.print(b + " ");
            a=b;
            b=temp;
        }
        
    }

}

