/*
Sieve_of_Eratosthenes is used to find all the prime numbers upto a specified integer. 
It creates a list of all numbers in the range, marking as composite the multiples of each Prime number, 
starting with the first Prime 2. The numbers that remains unmarked at the end are the primes.
*/

import java.util.*;
public class Sieve_of_Eratosthenes{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        int result = countPrimes(n);
        System.out.println("The Count of Prime numbers are : " + result);

    }
    /*
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
            //return true;   
        }
        return true;
    }
    */

    public static int countPrimes(int n){
        if(n <= 2) return 0;

        //Creating a array
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i*i < n; i++){
            if(isPrime[i]){
                //Mark the composites as false 
                for(int j = i*i; j < n; j+=i){
                    isPrime[j] = false;
                }
            }
        } 
        System.out.println("The Prime Numbers are : ");
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
}
