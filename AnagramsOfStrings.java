import java.util.*;
public class AnagramsOfStrings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings :");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the strings:");
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println("The given Strings are Anagrams of Strings : " + isAnagram(s, t));
    } 
    //Approch 1 - Using Sorting Technique

    /*
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        //Needs to convert into Arrays for Sorting

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        while(i < arr1.length){
            if(arr1[i] != arr2[i]){
                return false;
            }
            i++;
        }
        return true;
    }
    */

    //Approch 2 - Using Frequency Count
    
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        
        int[] freq = new int[26];

        for(int i = 0 ; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
}
