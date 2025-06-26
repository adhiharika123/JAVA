import java.util.*;
public class CountInversions{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int result = CountInversions(arr, n);
        System.out.println("The Inversions are : " + result);
    }
    //Approch 1 : Brute Force
    /*
    public static int CountInversions(int arr[], int n){
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(i < j){
                    if(arr[i] > arr[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    */
    public static int CountInversions(int arr[], int n){
        //Count the number of pairs:
        return Mergesort(arr, 0, n-1);
    }

    public static int Mergesort(int arr[], int low, int high){
        int cnt = 0 ;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += Mergesort(arr, low, mid); //left half
        cnt += Mergesort(arr, mid+1, high); //right half
        cnt += Merge(arr, low, mid, high); //merging sorted halves
        return cnt;       
    }

    public static int Merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt =0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                cnt += (mid-left+1);
                right++;
            }
        }
        //if elements on the left half are still left 
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        //if elements on the right half are still left 
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        //transfering all elements from temporary to arr 
        for(int i = low ; i <= high ; i++){
            arr[i] = temp.get(i-low);
        }
        return cnt;
    }
}