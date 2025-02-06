import java.util.*;
public class EligibleToVoteOrNot {
    public static void VoteOrNot(int age){
        if(age>18){
            System.out.println("You are Eligible to vote....!");
        }
        else{
            System.out.println("You are not Eligible to vote....!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age:");
        int age = sc.nextInt();
        VoteOrNot(age);
    }
}
