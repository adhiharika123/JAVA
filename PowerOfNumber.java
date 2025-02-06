import java.util.*;
public class PowerOfNumber {
    public static void GetPowerOfNumber(double base, double power){
        double result = Math.pow(base, power);
        System.out.println("The power of a number is :" + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");
        double base = sc.nextInt();
        double power = sc.nextInt();
        GetPowerOfNumber(base,power);
    }
}
