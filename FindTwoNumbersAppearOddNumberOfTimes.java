import java.util.Scanner;

public class FindTwoNumbersAppearOddNumberOfTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Find(arr);
    }
    public static void Find(int[] arr){
        int XOR = 0;
        for(int num : arr){
            XOR ^= num;
        }
        //setBit is to find the differentiate number 
        int setBit = XOR & -XOR;
        //Grouping into 2 Groups
        int n1=0, n2=0;
        for(int num : arr){
            if((num & setBit) != 0){
                n1 ^= num;
            }
            else{
                n2 ^= num;
            }
        }
        System.out.println("Two numbers are " + n1 + " and " + n2);
    }
}
