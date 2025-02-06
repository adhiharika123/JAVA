import java.util.*;
public class Function{
    public static void PrintMyName(String name){
        System.out.println("My name is:" + name);
    }

    public static void main(String args[]){
        System.out.println("Enter name here:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        PrintMyName(name);
    }
}