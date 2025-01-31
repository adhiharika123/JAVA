// Make a menu driven program. The user can enter 2 numbers, either 1 or 0.
// If the user enters 1 then keep taking input from the user for a student’s
// marks(out of 100).
// If they enter 0 then stop.
// If he/ she scores :
// Marks >=90 -> print “This is Good”
// 89 >= Marks >= 60 -> print “This is also Good”
// 59 >= Marks >= 0 -> print “This is Good as well”
// Because marks don’t matter but our effort does.
// (Hint : use do-while loop but think & understand why):
// The do-while loop ensures the user is presented with the menu at least once and continues running until the user opts to stop the program.
// The inner while loop for marks input ensures multiple entries can be made until the user decides to stop.
import java.util.*;
public class MenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Eithe 1 or 0 :");
        int number;

        do{
            System.out.println(("Enter 1 to input marks or 0 th exit"));
            number = sc.nextInt();
            if(number==1){
                System.out.println("Enter the Marks:");
                int marks = sc.nextInt();
                if(marks >= 90 && marks <= 100){
                    System.out.println("This is Good");
                }
                else if(marks >= 60 && marks <= 89){
                    System.out.println("This is also Good");

                }
                else if(marks >= 0 && marks <= 60){
                    System.out.println("This is Good as well");
                }
                else{
                    System.out.println("Invalid one, please enter values between 0 and 100");
                }
            }
            else if(number !=1){
                    System.out.println("Invalid one enter 1 to input marks ");
                }
        }while(number != 0);
        System.out.println("Exiting the program, Bye Bye...!");
    }
}
