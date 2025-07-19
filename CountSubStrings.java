import java.util.*;
public class CountSubStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = sc.nextLine();
        System.out.println("The number of substrings are : " + countSubString(s));
    }
    public static int countSubString(String s){
        int count = 0;
        int n = s.length();
        if(s.contains(" ")){
            count =  n * (n+1) /2 + 1;
        }
        else{
            count = n * (n+1)/2;
        }
        
        //Print All SubStrings 
        System.out.println("The SubStrings are : ");
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1 ; j <= s.length(); j++){
                System.out.println(s.substring(i,j));
            }
        }
        
        return count;
    }
     
}
