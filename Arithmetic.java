import java.util.*;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a and b values");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int Number = sc.nextInt();
        switch (Number) {
            case 1:
                System.out.print("Addition" + (a + b));
                break;
            case 2:
                System.out.println("Subtraction" + (a - b));
                break;
            case 3:
                System.out.println("Multiplication" + (a * b));
                break;
            case 4:
                System.out.println("Division" + (a / b));
                break;
            case 5:
                System.out.println("Modulus" + (a % b));
            default:
                break;
        }

    }

}
