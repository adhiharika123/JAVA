import java.util.*;
public class LongestPalindromeString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.nextLine();
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        //Expand Around Center Approach
        if(s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < s.length() ; i++){
            int l1 = expandForCenter(s,i,i);    //odd length center : 'aba'
            int l2 = expandForCenter(s,i,i+1);  //even length center : 'abba'
            int len = Math.max(l1, l2);

            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    //Expanding outwards while characters match
    private static int expandForCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}