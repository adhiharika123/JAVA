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
