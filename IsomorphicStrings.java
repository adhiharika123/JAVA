import java.util.*;
public class IsomorphicStrings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings :");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the strings:");
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println("The given Strings are Isomorphic: " + isIsomorphic(s, t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        //Create two hash maps to keep track of mapping
        Map<Character,Character> S1 = new HashMap<>();
        Map<Character,Character> T1 = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(S1.containsKey(s1)){
                if(S1.get(s1) != t1){
                    return false;
                }
            }
            else{
                S1.put(s1,t1);
            }

            if(T1.containsKey(t1)){
                if(T1.get(t1) != s1){
                    return false;
                }
            }
            else{
                T1.put(t1,s1);
            }
        }
        return true;
    }

}
