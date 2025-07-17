import java.util.*;
public class LongestCommonPrefix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings :");
        int n = sc.nextInt();
        sc.nextLine();
        String strs[] = new String[n];
        System.out.println("Enter strings:");
        for(int i = 0 ; i < strs.length ; i++){
            strs[i] = sc.nextLine();
        }
        System.out.println("The Longest common prefix is : " + longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minlength = Math.min(first.length(), last.length());

        int i = 0;
        while(i < minlength && first.charAt(i) == last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}