/* Design an algorithm that collects daily price quotes for some stock and returns 
the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days 
(starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, 
then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days. */

import java.util.*;

public class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockSpanner obj = new StockSpanner();
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter prices : ");
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        for (int price : prices) {
            System.out.print(obj.next(price) + " ");
        }
    }
    //Brute Force
    /*
    private List<Integer> prices;
    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int span = 1;
        for(int i = prices.size()-2; i >= 0; i--){
            if(prices.get(i) <= price){
                span++;
            }
            else{
                break;
            }
        }
        return span;
    }
    */

    //Optimal Approach 

    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            span += st.pop()[1];
        }
        st.push(new int[] {price, span});
        return span;
    }
}
