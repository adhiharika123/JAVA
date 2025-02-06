import java.util.*;
public class CircumferenceOfCircle {

    public static void GetCircumferenceOfCircle(float radius){
        final float pi=3.14f;
        float circumference = 2*pi*radius;
        System.out.println("The Circumference of the circle is:" + circumference);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius value:");
        float radius = sc.nextFloat();
        GetCircumferenceOfCircle(radius);
    }
}