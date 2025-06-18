import java.util.*;
public class StockBuyandSell{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The maximum profit is : " + BuyAndSell(arr, n));
    }
    //Approch 1 : Using Two loops TC:O(N^2)
    /* 
    public static int BuyAndSell(int arr[], int n){
        int max_profit = 0;
        for(int i = 0 ; i < n ; i++){
            int profit = 0;
            for(int j = i+1 ; j < n ; j++){
                profit = Math.max(profit,arr[j] - arr[i]);
            }
            if(profit > max_profit){
                max_profit = profit;
            }
        }
        return max_profit;
    }
    */
   public static int BuyAndSell(int arr[], int n){
    int max_profit = 0 ;
    int min_price = Integer.MAX_VALUE;
    for(int i = 0 ; i < n ; i++){
        int profit = 0 ;
        if(arr[i] < min_price){
            min_price = arr[i];
        }
        profit = arr[i] - min_price;
        if(profit > max_profit){
            max_profit = profit;
        }
    }
    return max_profit;
   }
}