import java.util.*;
class SumOf_N_NaturalNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N value");
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum = sum + i;
        }
        System.out.println("Sum Of N natural Numbers are:" + sum);

    }
}