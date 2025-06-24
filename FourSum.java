import java.util.*;
public class FourSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value :");
        int n = sc.nextInt();
        System.out.println("Enter target value :");
        int target = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(Sum(arr,n,target));
    }
    public static List<List<Integer>> Sum(int arr[],int n, int target){
        List<List<Integer>> res = new ArrayList<>();
        //Sort an array in ascending order
        Arrays.sort(arr);

        for(int i = 0 ; i< n ; i++){
            //To skip Duplicate i values
            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }
            for(int j = i+1 ; j < n ; j++){
                if(j > i+1 && arr[j] == arr[j-1]){
                    continue;
                }
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = (long)arr[i]+(long)arr[j]+(long)arr[k]+(long)arr[l];
                    
                    if(sum < target){
                        k++;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else{
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        res.add(temp);
                        k++;
                        l--;

                        while(k < l && arr[k] == arr[k-1]) k++; // To skip Duplicate j values
                        while(k < l && arr[l] == arr[l+1]) l--; // To skip Duplicate k values
                    }
                }
            }    
        }
        return res;
    }
}