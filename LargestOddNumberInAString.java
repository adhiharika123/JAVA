import java.util.Scanner;

public class LargestOddNumberInAString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.nextLine();
        System.out.print("The largest odd number in a string is : " + largestOddNumber(s));
    }
    public static String largestOddNumber(String num) {
        //char maxOdd = '0';
        for(int i = num.length() - 1; i >= 0; i--){
            char ch = num.charAt(i);
            if((ch - '0') % 2 == 1){
                return num.substring(0,i+1);
            }
        }
        return "";        
    }
}
