import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string digits : ");
        String digits = sc.next();
        List<String> array = letterCombinations(digits);
        System.out.println("The Combinations are : ");
        for(String arr : array){
            System.out.print(arr + " ");
        }
        System.out.println();
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        //Mapping digits to string
        String[] mapping = {
            "",     //0
            "",     //1
            "abc",   //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs",  //7
            "tuv",  //8
            "wxyz"  //9
        };
        combinations(result, digits, mapping, 0, new StringBuilder());
        return result;
    }
    public static void combinations(List<String> result, String digits, String[] mapping, int index, StringBuilder path){
        //Base case
        if(index == digits.length()){
            result.add(path.toString());
            return;
        }

        //Current digit
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];

        //Try each possible letter for this digit
        for(char ch : letters.toCharArray()){
            path.append(ch);        //Choose
            combinations(result, digits, mapping, index+1, path);       //Recursive add 
            path.deleteCharAt(path.length() - 1);     //Undo(Backtrack)
        }
    }
}
