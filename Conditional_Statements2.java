import java.util.Scanner;

public class Conditional_Statements2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Button");
        int Button = sc.nextInt();
        switch (Button) {
            case 1:
                System.out.println("Hello");               
                break;
            case 2:
                System.out.println("Namaste");
                break;
            case 3:
                System.out.println("Bonjour");
            default:
                System.out.println("Invalid Number");
        }
    }
}
