/* Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c. */

import java.util.*;
public class SubstringContainingAll3Characters {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s = sc.nextLine();
        int result = numberOfSubstrings(s);
        System.out.println("The Number of Substrings Containing All Three Characters are : " + result);
    }
    //  Brute Force
    /*
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;
                if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                    count++;
                }
            }
        }
        return count;
    }
    */

    //  Optimal Approach
    public static int numberOfSubstrings(String s){
        int n = s.length();
        int count = 0;
        int[] freq = new int[26];
        int left = 0;
        for(int right = 0; right < n; right++){
            freq[s.charAt(right) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += (s.length() - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
}
