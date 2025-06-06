import java.util.*;
class PrintNameNTimes{
    public static void PrintName(int i,int n,String name){
        while(i<=n){
           System.out.println("Hello:" + name);
           i++;
        }
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Printing my name N times:");
        PrintName(1,n,name);
    }
    
}