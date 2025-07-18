import java.util.*;
public class RomanToInteger {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String value: ");
        String s = sc.nextLine();
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++){          
            int val = map.get(s.charAt(i));
            //If a smaller value comes before a larger one (like IV), subtract it.
            if(i+1 < s.length() && val < map.get(s.charAt(i+1))){
                result -= val;
            }
            //Else, add it.
            else{
                result += val;
            }
        }
        return result;
    }

}
