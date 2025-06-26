import java.util.*;
public class ReversePairs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int result = ReversePair(arr, n);
        System.out.println("The Reverse Pairs are : " + result);
    }
    //Approch 1 : Brute Force TC: O(N)^2;
    /* 
    public static int ReversePair(int arr[], int n){
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(i < j){
                    if(arr[i] > 2*arr[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    */

    //Approch 2 : Using Merge Sort TC:O(2(N)log(N))
    public static int ReversePair(int arr[], int n){
        //Count the number of pairs:
        return Mergesort(arr, 0, n-1);
    }

    public static int Mergesort(int arr[], int low, int high){
        int cnt = 0 ;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += Mergesort(arr, low, mid); //left half
        cnt += Mergesort(arr, mid+1, high); //right half
        cnt += CountPairs(arr, low, mid, high); //Count Pairs
        Merge(arr, low, mid, high); //merging sorted halves
        return cnt;       
    }

    public static int CountPairs(int arr[], int low, int mid, int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i] > 2*(long)arr[right]){
                right++;   
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }

    public static void Merge(int arr[], int low, int mid, int high){
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
    }
}