import java.util.*;
public class Average {

    public static float AverageOfNumbers(float n1, float n2,float n3){
        return (n1+n2+n3)/3;
    }
    public static void main(String[] args) {
        System.out.println("Enter numbers");
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        System.out.println("The Average of the given numbers is :");
        System.out.println(AverageOfNumbers(a,b,c));
    }
}
