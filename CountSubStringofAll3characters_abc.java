import java.util.Scanner;

public class CountSubStringofAll3characters_abc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = sc.nextLine();
        System.out.println("The number of substrings are : " + countSubString(s));
    }
    public static int countSubString(String s){
        int count = 0;
        int n = s.length();
        
        //Print All SubStrings 
        System.out.println("The SubStrings are : ");
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1 ; j <= s.length(); j++){
                String sub = s.substring(i,j);       
                if(sub.contains("abc"))
                {
                    System.out.println(sub);
                    count++;
                }
            }       
        }
        return count;
    }
}

