import java.util.*;
public class StringToInteger_atoi{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.nextLine();
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        int sign = 1;
        long result = 0;
        boolean started = false;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == ' ' && !started){
                continue;
            }
            if((ch == '+' || ch == '-') && !started){
                sign = (ch == '-') ? -1 : 1;
                started = true;
                continue;
            }
            if(!Character.isDigit(ch)){
                break;
            }
            result = result * 10 + (ch - '0');
            started = true;

            if(sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && result > (long)Integer.MAX_VALUE + 1) return Integer.MIN_VALUE;
        }
        return (int)result * sign;
    }
}