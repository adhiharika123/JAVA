import java.util.*;
public class RemoveOuterParanthesis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.next();
        System.out.print(removeOuterParentheses(s));
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int cnt = 0;
        for(char c: s.toCharArray()){ 
            if(c == '('){
                if(cnt > 0){
                    result.append(c);
                }
                cnt++;
            }
            else{
                cnt--;
                if(cnt > 0){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
} 