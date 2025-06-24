import java.util.*;
public class Threesum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value :");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(Sum(arr));
    }
    public static List<List<Integer>> Sum(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        //Sort an array in ascending order
        Arrays.sort(arr);

        for(int i = 0 ; i< arr.length-1 ; i++){
            //To skip Duplicate i values
            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }
            
            int j = i+1;
            int k = arr.length-1;
            while(j < k){
                int sum = arr[i]+arr[j]+arr[k];
                
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    res.add(temp);

                    while(j < k && arr[j] == arr[j+1]) j++; // To skip Duplicate j values
                    while(j < k && arr[k] == arr[k-1]) k--; // To skip Duplicate k values

                    j++;
                    k--;
                }

                
            }
        }
        return res;
    }
}