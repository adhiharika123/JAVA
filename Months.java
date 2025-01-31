import java.util.*;
public class Months {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month Number");
        int month = sc.nextInt();
        switch (month) {
            case 1:
                System.err.println("January");
                break;
            case 2:
                System.err.println("February");
                break;
            case 3:
                System.err.println("March");
                break;
            case 4:
                System.err.println("April");
                break;
            case 5:
                System.err.println("May");
                break;
            case 6:
                System.err.println("June");
                break;
            case 7:
                System.err.println("July");
                break;
            case 8:
                System.err.println("August");
                break;
            case 9:
                System.err.println("September");
                break;
            case 10:
                System.err.println("October");
                break;
            case 11:
                System.err.println("November");
                break;
            case 12:
                System.err.println("December");
                break;
            default:
            System.out.println("Invalid");
                break;
        }
    }
}
