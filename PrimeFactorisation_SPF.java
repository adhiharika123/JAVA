import java.util.*;
public class PrimeFactorisation_SPF {
    static final int max = 1000000;
    static int[] spf = new int[max + 1]; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seive();        //Build the Seive table for Pre Computations
        System.out.println("Enter the N value : ");
        int n = sc.nextInt();
        getPrimeFactorization(n);
    }
    public static void Seive(){
        for(int i = 2; i <= max; i++){
            spf[i] = i;
        }
        for(int i = 2; i*i <= max ; i++){
            if(spf[i] == i){                //If it is a Prime
                for(int j = i*i; j <= max; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;         // Mark with their Smallest Prime Factor(SPF)
                    }
                }
            }
        }
    }
    public static void getPrimeFactorization(int n){
        System.out.println("The PrimeFactorization of " + n + " is : ");
        while(n != 1){
            System.out.print(spf[n] + " ");
            n = n / spf[n];
        }
    }
}
