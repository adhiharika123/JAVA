import java.util.*;
public class RotateString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings :");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the strings:");
        String s = sc.nextLine();
        String goal = sc.nextLine();
        System.out.println("The given Strings are Rotated : " + rotateString(s, goal));
    }
    public static boolean rotateString(String s, String goal){
        if(s.length() != goal.length()) return false;
        String doubles = s + s;
        return doubles.contains(goal);
    }
}