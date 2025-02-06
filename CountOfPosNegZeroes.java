import java.util.*;
public class CountOfPosNegZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positives=0;
        int negatives=0;
        int zeroes=0;
        System.out.println("Press 1 to Continue or 0 to Stop....!");
        int input=sc.nextInt();

        while(input==1){
            System.out.println("Enter your number:");
            int n=sc.nextInt();
            if(n>0){
                positives++;
            }
            else if(n<0){
                negatives++;
            }
            else{
                zeroes++;
            }

            System.out.println("Press 1 to Continue or 0 to Stop....!");
            input=sc.nextInt();

            System.out.println("Posivite Numbers Are:" + positives);
            System.out.println("Negative Numbers Are:" + negatives);
            System.out.println("Zeroes Are:" + zeroes);
            
        }

    }
}
