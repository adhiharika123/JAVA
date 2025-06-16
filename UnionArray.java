import java.util.*;
public class UnionArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array1 elements:");
        int arr1[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter array2 elements:");
        int arr2[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        HashSet <Integer> s=new HashSet<>();
        Union(arr1, arr2);
    }
    public static void Union(int arr1[], int arr2[]){ 
        Set<Integer> unionset = new TreeSet<>();  //Treeset for sorted array
        for(int num : arr1){
            unionset.add(num);
        }
        for(int num : arr2){
            unionset.add(num);
        }
        System.out.println("Unoin of Two arrays is :");
        for(int num : unionset){
            System.out.print(num + " ");
        }
    }
}
