import java.util.*;

public class PrimeFactorsOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value : ");
        int N = sc.nextInt();
        ArrayList<Integer> list = prime(N);
        System.out.println("The prime factors of a number is : " + list);
    }
    //Naive Approach
    /*
    public static ArrayList<Integer> prime(int N){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= N ; i++){
            while( N % i == 0 && N > 0){
                ans.add(i);
                N = N/i;
            }
        }
        return ans;
    }
    */

    //Optimal Approach 
    public static ArrayList<Integer> prime(int N){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(N) ; i++){
            while( N % i == 0 && N > 0){
                ans.add(i);
                N = N/i;
            }
        }
        return ans;
    }
}
