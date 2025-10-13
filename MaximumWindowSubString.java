import java.util.*;

public class MaximumWindowSubString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s = sc.nextLine();
        System.out.println("Enter the target : ");
        String t = sc.nextLine();
        String result = minWindow(s, t);
        System.out.println("The Maximum Window Substring is : " + result);
    }
    //  Brute Force
    /*
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int minlen = Integer.MAX_VALUE;
        String result = "";

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String sub = s.substring(i, j+ 1);
                if(containsAll(sub, t)){
                    if(sub.length() < minlen){
                        minlen = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
    private static boolean containsAll(String sub, String t){
        int[] freq = new int[128];
        for(char c : sub.toCharArray()){
            freq[c]++;
        }
        for(char c : t.toCharArray()){
            if(freq[c] -- <= 0){
                return false;
            }
        }
        return true;
    }
    */

    //  Optimal Approach
    public static String minWindow(String s, String t){
        if(t.length() > s.length()) return "";
        Map<Character, Integer> target = new HashMap<>();
        for(char c : t.toCharArray()){
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int required = target.size();
        int left = 0, right = 0;
        int formed = 0;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0) + 1);

            if(target.containsKey(c) && window.get(c).equals(target.get(c))){
                formed++;
            }
            while(left <= right && formed == required){
                if((right - left + 1) < minlen){
                    minlen = (right - left + 1);
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(target.containsKey(leftChar) && window.get(leftChar) < target.get(leftChar)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
