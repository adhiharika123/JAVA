import java.util.*;
class FindXOROfNumbersfromLToR{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter L to R : ");
        System.out.println("The L value is : ");
        int L = sc.nextInt();
        System.out.println("The R value is : ");
        int R = sc.nextInt();
        int result = Find(L, R);
        System.out.println("The XOR from L to R is : " + result);
    }
    public static int Find(int L , int R){
        int xor = 0;
        for(int i = L ; i <= R ; i++){
            xor = xor ^ i;
        }
        return xor;
    }
}