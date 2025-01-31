import java.util.*;
public class EvenNumbers {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter N value: ");
      int n = sc.nextInt();
      for(int i = 2; i <= n; i++){
        if(i % 2 == 0){
            System.out.println("Even Number is " + i);
        }
      }  
    }
}
