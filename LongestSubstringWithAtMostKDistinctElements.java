import java.util.*;
public class LongestSubstringWithAtMostKDistinctElements{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String value : ");
        String s = sc.nextLine();
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        int result = longestKSubstr(s,k);
        System.out.println("The Longest Substring With AtMost K Distinct Elements is : " + result);
    }
    //  Brute Force
    /*
    public static int longestKSubstr(String s, int k) {
        // code here
        int maxlength = 0;
        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> freq = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j),0)+1);
                if(freq.size() > k){
                    break;
                }
                maxlength = Math.max(maxlength, (j - i + 1));
            }
        }
        return maxlength;
    }
    */
    
    //  Optimal Approach
    public static int longestKSubstr(String s, int k){
        if(k == 0 || s.length() == 0 ) return -1;
        int maxlength = 0;
        // int maxlength = -1;   // Exactly k
        int left = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while(freq.size() > k){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if(freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }
                left++;
            }
            maxlength = Math.max(maxlength, (right - left + 1));
            //  Exactly k 
            /*
            if(freq.size() == k){
                maxlength = Math.max(maxlength, (right - left + 1));
            }
            */
        }
        return maxlength;
    }
}