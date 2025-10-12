import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s = sc.nextLine();
        System.out.println("Enter the k value : ");
        int k = sc.nextInt();
        int result = characterReplacement(s, k);
        System.out.println("The Longest Repeating Character Replacement Character is : " + result);
    }
    //  Brute Force 
    /*
    public static int characterReplacement(String s, int k) {
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
                int windowSize = j - i + 1;
                int replacements = windowSize - maxFreq;
                if(replacements <= k){
                    maxlen = Math.max(maxlen, windowSize);
                }
            }
        }
        return maxlen;
    }
    */

    //  Optimal Approach
    public static int characterReplacement(String s, int k){
        int[] freq = new int[26];
        int maxlen = 0;
        int maxFreq = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            //  Shrinking the window size
            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}
