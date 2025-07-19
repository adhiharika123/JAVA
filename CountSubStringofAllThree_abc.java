import java.util.Scanner;

public class CountSubStringofAllThree_abc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = sc.nextLine();
        System.out.println("The number of substrings are : " + numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s) {
        
        //BruteForce Approch
        /*
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1 ; j <= s.length() ; j++){
                String sub = s.substring(i,j);

                if(sub.contains("a") && sub.contains("b") && sub.contains("c")){
                    count++;
                }
            }
        }
        return count;
    */

    //Using Optimized Version - Sliding Window Concept
        int count =0;
        int left = 0;           //Start of window
        int freq[] = new int[3];

        for(int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'b' || ch == 'c'){
                freq[ch - 'a']++;                       //Increase count of current window
            }
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += s.length() - right;

                //To start next window say 'bca' from string = 'abcabc'
                char leftChar = s.charAt(left);
                if(leftChar == 'a' || leftChar == 'b' || leftChar == 'c'){
                    freq[leftChar - 'a']--;
                }
                left++;
            }
        }
        return count;
    }
}
