import java.util.*;
public class GenerateAllBinaryStringsWithoutConsecutiveOnes {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value : ");
        int N = sc.nextInt();
        System.out.println("The Binary Strings are : ");
        generate(N, "");
    }

    public static void generate(int N , String str){
        if(N == 0){
            System.out.println(str);
            return ;
        }
        generate(N-1, str + "0");

        //The if condition is only used when we want to generate binary strings without consecutive ones
        if(str.length() == 0 || str.charAt(str.length()-1) != '1'){
            generate(N-1, str + "1");
        }
        
    }
}
