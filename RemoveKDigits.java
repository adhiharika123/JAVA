/* Given string num representing a non-negative integer num,and an integer k, 
return the smallest possible integer after removing k digits from num. */

import java.util.*;

public class RemoveKDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String Characters : ");
        String arr = sc.nextLine();
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        String result = removeKdigits(arr, k);
        System.out.println(result);
    }
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        //  Build final number
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        //  Removing leading zeroes
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString(); 

    }
}
